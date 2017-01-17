<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="it.uniroma2.ispw.bean.*" %>
<%@ page import="it.uniroma2.ispw.controller.*" %>
<%@ page import="it.uniroma2.ispw.model.*" %>
<%@ page import="it.uniroma2.ispw.session.*" %>
<%@ page import="java.util.*" %>

<jsp:useBean id="loginb" scope="session" class="it.uniroma2.ispw.bean.LoginBean"/>
<jsp:setProperty name="loginb" property="*"/>

<jsp:useBean id="pagamentob" scope="session" class="it.uniroma2.ispw.bean.PagamentoBean"/>
<jsp:setProperty name="pagamentob" property="*"/>

<%


UtenteSessione us = (UtenteSessione) session.getAttribute("utente");


%>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shopping-Express</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="css/agency.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Shopping Express</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="index.jsp">Cerca prodotto</a>
                    </li>
                  
                    
                    <%if (us==null){ %>
                    
                    <li>
                        <a class="forget" data-toggle="modal" data-target=".forget-modal-login" href="#modalLogin">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="registrazione.jsp">Registrazione</a>
                    </li>
                    
                    <%}else if (us.getType()==2){ %>
                     <li>
                        <a class="forget" data-toggle="modal" data-target=".forget-modal-logout" href="#modalLogout" >Logout</a>
                    </li>
                     <li>
                        <a class="page-scroll" href="profilo.jsp">Profilo</a>
                    </li>
                      <li>
                        <a class="page-scroll" href="listaAcquisti.jsp">Tuoi acquisti</a>
                    </li>
                     <li>
                        <a class="page-scroll" href="carrello.jsp">Carrello</a>
                    </li>
                   
                    <%}else if (us.getType()==1) { %>
                    <li>
                        <a class="forget" data-toggle="modal" data-target=".forget-modal-logout" href="#modalLogout" >Logout</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="profilo.jsp">Profilo</a>
                    </li>
                     <li>
                        <a class="page-scroll" href="annunci.jsp">Tuoi annunci</a>
                    </li>
                     <li>
                        <a class="page-scroll" href="prova.jsp">Tue Vendite</a>
                    </li>
                    
                    
                    <%}%>
                    <li>
                        <a class="page-scroll" href="#team"></a>
                    </li>
                
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>


	<div id="modalLogout" class="modal fade forget-modal-logout" tabindex="-1" role="dialog" aria-labelledby="myLoginModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">x</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">Logout</h4>
					</div>	
					<div class="modal-body">
						<p>Sicuro di abbandonare la sessione?</p>					
					</div>
					<div class="modal-footer">	
					
					<form action="index.jsp" method="post">		
						<input class="btn btn-custom" type="submit" id="btn-logout" name="logout" value="Abbandona">
					</form>
					</div>
				</div>
			</div>
	</div>	

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                
                <%if (us==null){ %>
                	<div class="intro-lead-in">Benvenuto nel nostro sito di e-commerce!</div>
                	<div class="intro-heading">It's Nice To Meet You</div>
                <%}else if ((us.getType()==1)||(us.getType()==2)){ %>
                
                	<div class="intro-lead-in">Bentornato nel nostro sito di e-commerce, <%= us.getUserid() %>!</div>
                	<div class="intro-heading">It's Nice To Meet You</div>
                
                
                <%} %>
            </div>
        </div>
    </header>
    
    <% pagamentob.popolaLista(us.getEmail()); %>
    
<section>
	<div id="page-wrapper">

			<div class="row text-center">
				<div class="panel panel-default">
					<div class="panel-heading"><h4>Lista acquisti</h4></div>
				</div>
			</div>
			
			<%
				List<Pagamento> lp = pagamentob.getListaPag();
				List<LineaOrdine> lo = null;
				Pagamento p = null;
				LineaOrdine l = null;
				if(lp.size() != 0){
					for(int i=0; i<lp.size(); i++){
						p = lp.get(i);
						lo = p.getOrdine().getLineeOrdine();
			%>
			
			<div class="panel panel-default">
				<div class="panel-heading">Pagamento ordine id: <%= p.getOrdine().getIdOrdine()%></div>
					
					<table class="table">
						<thead>
							<tr>
							<th>#</th>
							<th>Nome prodotto</th>
							<th>Prezzo</th>
							</tr>
						</thead>	
						<tbody>
						<%
							for(int j=0; j<lo.size(); j++){
								l = lo.get(j);
						%>
						
							<tr>
							<th scope="row"><%= j %></th>
							<td><%= l.getProdotto().getNome() %></td>
							<td>$<%= l.getPrezzoLinea() %> </td>
							</tr>
						
						
						<% } %>
						</tbody>					
					</table>
				<div class="panel-footer">
					<h4>$<%= p.getImporto() %></h4>
				</div>
			</div>
			
			<% }} %>
		</div>

</section>    


    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Copyright &copy; Your Website 2016</span>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline quicklinks">
                        <li><a href="#">Regolamento</a>
                        </li>
                        <li><a href="#">Contattaci</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    
    


    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/agency.min.js"></script>

</body>

</html>


