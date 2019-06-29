/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import persistencia.CampanhaDao;
import persistencia.Dao;

	public class EnviarEmail extends Dao{

        private String emailDestinatario;

        private String assunto;
        private String msg;

        public String getEmailDestinatario() {
            return emailDestinatario;
        }

        public void setEmailDestinatario(String emailDestinatario) {
            this.emailDestinatario = emailDestinatario;
        }

        public String getAssunto() {
            return assunto;
        }

        public void setAssunto(String assunto) {
            this.assunto = assunto;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        
        public boolean enviarGmail(String email, String senha, String assunto, String mensagem) {
            boolean retorno = false;
            
            		
		try {
			CampanhaDao cd = new CampanhaDao();
			abrirConexao();
			stmt = con.prepareStatement("select * from propaganda");
			System.out.println("ENTROU NO SELECT PROPAGANDA");
			rs = stmt.executeQuery();

			int i = 1;
			while (rs.next()) {
				
				//Get the session object  
	            Properties props = new Properties();
	            props.put("mail.smtp.host", "smtp.gmail.com");
	            props.put("mail.smtp.socketFactory.port", "465");
	            props.put("mail.smtp.socketFactory.class",
	                    "javax.net.ssl.SSLSocketFactory");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.port", "465");
	            String mail = email;

				Session s = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication(mail, senha);// email e senha usu√°rio
					}
				});

				System.out.println("Entrou no ENQUANTO: " + i);
				System.out.println(email + "| i: " + i);
				System.out.println("Enviando para o email " + rs.getString("email"));
				
				
				//compose message 
				MimeMessage message = new MimeMessage(s);
				message.setFrom(new InternetAddress(email));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(rs.getString("email")));

				message.setSubject("Ol· " + rs.getString("nome") + " - " + assunto + " " + new Date().toString().substring(4, 20));
				message.setContent(cd.findByCode(rs.getInt("numpropaganda")).getTexto(), "text/html; charset=utf-8");

				// send message
				Transport.send(message);
				System.out.println("ENVIOU A MENSAGEM");
				
				stmt = con.prepareStatement("update propaganda set numpropaganda = "+ (rs.getInt("numpropaganda") + 1) + " where id = "+ rs.getInt("id"));
				stmt.execute();
				
				//Trocando o email de envio
				if (i <= 1) {
					email = "mais.vida.boaplena@gmail.com";
					i = 2;
				} else if (i == 2) {
					email = "vidaboa.mais.plena@gmail.com";
					i = 3;
				} else {
					email = "boa.vidaplena.mais@gmail.com";
					i = 1;
				}
				
				//props.clone();
				System.out.println("\n----\n");

			}
			fecharConexao();
			retorno = true;

			System.out.println("");
		} catch (Exception e) {
			System.out.println("Erro ao abrir a conex„o com o BD: " + e.getMessage());
			e.printStackTrace();
		}
		
		return retorno;
	}
        
        
        //------------------------------------
        public boolean enviarUmGmail(String nome, String email, String mensagem) {
            boolean retorno = false;
            //Get the session object  
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            String mail = email;
            
            Session s = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {

                            return new PasswordAuthentication("vidaboa.mais.plena@gmail.com", "bruno2013");//email e senha usu√°rio 
                        }
                    });
            		
            //compose message  
            
            try {
            	            		
				    MimeMessage message = new MimeMessage(s);
				    message.setFrom(new InternetAddress(email));
				    message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));

				    message.setSubject("Ol· "+ nome + "!! Estamos felizes em ter vocÍ aqui!! :D - " + new Date().toString().substring(4, 20));
				    message.setContent(mensagem, "text/html; charset=utf-8");

				    //send message  
				    Transport.send(message);
				    System.out.println("--------");
				    retorno = true;
					
				} catch (MessagingException e) {
				    retorno = false;
				    e.printStackTrace();
				}
            props.clone();
            return retorno;
        }
        
        //------------------------------------------------------------------------------------------------------
        
        public String enviarHotmail(String titulo, String destinatario, String texto, Integer qtd)
        
        {
            String retorno = "Erro!!"; 
            Properties props = new Properties();
                /** Par‚metros de conex„o com servidor Hotmail */
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.host", "smtp.live.com");
                props.put("mail.smtp.socketFactory.port", "587");
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");

                Session session = Session.getDefaultInstance(props,
                            new javax.mail.Authenticator() {
                                 protected PasswordAuthentication getPasswordAuthentication() 
                                 {
                                       return new PasswordAuthentication("tinholl@hotmail.com", "Mesmo3215**");
                                 }
                            });
                /** Ativa Debug para sess„o */
                session.setDebug(true);
                
                try {
                	abrirConexao();
                	
                	try {
						
                		stmt = con.prepareStatement("select * from propaganda");
    					rs = stmt.executeQuery();
    					
    					while (rs.next()) {
    						
    					try {
    						String email = rs.getString("email");
    						String nome = rs.getString("nome");
    						Message message = new MimeMessage(session);
    						message.setFrom(new InternetAddress("tinholl@hotmail.com")); // Remetente
    			
    						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // Destinat√°rio(s)
    						message.setSubject(titulo + " " + qtd + "a");// Assunto
    						message.setContent("Ol· "+ nome + ",</br></br>" + texto, "text/html");// Mensagem
    						// MÈtodo para enviar a mensagem criada
    						Transport.send(message);
    						System.out.println("Email enviado!!");
    						retorno = "Enviado Com sucesso!!";

    	                 } catch (MessagingException e) {
    	                      throw new RuntimeException(e);
    	                }
    					}
    					
					} catch (Exception e) {
						// TODO: handle exception
					}
                	
                	
				fecharConexao();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                
                
                return retorno;
        
        }
        	
        //----------------------------------------------------------------------------
        public void enviarHotmail2(String titulo, String texto, String destinatario, String nome, String EmailRemetente){
            
        	String retorno = "Erro!!"; 
            Properties props = new Properties();
                /** Par‚metros de conex„o com servidor Hotmail */
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.host", "smtp.live.com");
                props.put("mail.smtp.socketFactory.port", "587");
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");

                Session session = Session.getDefaultInstance(props,
                            new javax.mail.Authenticator() {
                                 protected PasswordAuthentication getPasswordAuthentication() 
                                 {
                                       return new PasswordAuthentication(EmailRemetente, "Jesuseamor");
                                 }
                            });
                /** Ativa Debug para sess„o */
                //session.setDebug(true);
					
                	try {
    						
    						Message message = new MimeMessage(session);
    						message.setFrom(new InternetAddress(EmailRemetente)); // Remetente
    						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario)); // Destinat√°rio(s)
    						message.setSubject(titulo + " - " + nome);// Assunto
    						message.setContent("Ol· "+ nome + ",</br></br>" + texto, "text/html");// Mensagem
    						// MÈtodo para enviar a mensagem criada
    						Transport.send(message);
    						System.out.println("Email enviado!!");
    						retorno = "Enviado Com sucesso!!";
                		}
                	
                	catch (Exception e) {
						 System.out.println("N„o conseguiu enviar: "+ e.getMessage());
					}
                	
        }
        
        //----------------------------------------------------------------------------
        
        
        
        
        public Integer enviarEmailTodos(String titulo, String texto){
            Integer retorno = 0; 
            
            Properties props = new Properties();
                /** Par√¢metros de conex√£o com servidor Hotmail */
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.host", "mail.kabalmk.com.br");
                props.put("mail.smtp.socketFactory.port", "587");
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");

                Session session = Session.getDefaultInstance(props,
                            new javax.mail.Authenticator() {
                                 protected PasswordAuthentication getPasswordAuthentication() 
                                 {
                                       return new PasswordAuthentication("consolidacao@kabalmk.com.br", "Consolidar07");
                                 }
                            });
                /** Ativa Debug para sess√£o */
                session.setDebug(true);
                abrirConexao();
                
                try {
    			
                	stmt = con.prepareStatement("select * from consolidar");
                	rs = stmt.executeQuery();
                	int i = 0;
                	while(rs.next()) {
                		if(rs.getString("email")!=null) {
                		String email = rs.getString("email");
                		
                		Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("consolidacao@kabalmk.com.br")); //Remetente
                        
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); //Destinat·rio(s)
                        
                        message.setSubject(titulo);//Assunto
                        
                        message.setText("Para: "+ rs.getString("nome") +". \r\n\r\n"+ texto); //Mensagem
                        /**MÈtodo para enviar a mensagem criada*/
                        
                        Transport.send(message);
                        
                        System.out.println("Enviado para: " + rs.getString("nome"));
                		}
                		i = i+1;
                	}
                	
                	System.out.println("Achou na linha: "+i);
                	retorno = i;
                
                }catch (Exception e) {
    				System.out.println("Erro. Nada enviado.");
    			}
                
                return retorno;
        
        }
        
        //------------------------
        public boolean Gmail(String nome, String emailRemetente, String emailDestino, String mensagem) {
            boolean retorno = false;
            //Get the session object  
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            
            
            		
            //compose message  
            
            try {
            	
			Session s = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(emailRemetente, "bruno2013");// email e senha usu√°rio
				}
			});
            	            		
				    MimeMessage message = new MimeMessage(s);
				    message.setFrom(new InternetAddress(emailRemetente));
				    message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailDestino));

				    message.setSubject("Ol· "+ nome + "!! Estamos felizes em ter vocÍ aqui!! :D - " + new Date().toString().substring(4, 20));
				    message.setContent(mensagem, "text/html; charset=utf-8");

				    //send message  
				    Transport.send(message);
				    System.out.println("--------");
				    retorno = true;
					
				} catch (MessagingException e) {
				    retorno = false;
				    e.printStackTrace();
				}
            props.clone();
            return retorno;
        }
    

}
