<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="persistencia.CampanhaDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	CampanhaDao cd = new CampanhaDao();
	cd.deletar(Integer.parseInt(request.getParameter("id")));
%>
