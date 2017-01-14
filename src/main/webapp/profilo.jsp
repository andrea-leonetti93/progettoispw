<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="it.uniroma2.ispw.model.*" %>
<%@ page import="it.uniroma2.ispw.bean.*" %> 
<%@ page import="it.uniroma2.ispw.session.*" %>


<jsp:useBean id="updatebean" scope="session" class="it.uniroma2.ispw.bean.UpdateUtenteBean"/>
<jsp:setProperty name="updatebean" property="*"/>
    
<%

UtenteSessione us = (UtenteSessione) session.getAttribute("utente");
String errorMessage = "";

if(request.getParameter("salvaInfo") != null){
	
	if (updatebean.controlloCampi()){
		if (updatebean.updateUtente(us.getUserid(),us.getEmail())){
			errorMessage = "informazioni aggiornate";
		}
		else {
			errorMessage = "impossibile aggiornare";
		}
	}
	
	else {
		errorMessage = "Password diverse";
	}
}

if (!(updatebean.getUtente(us.getEmail()))){
	//errore, impossibile reperire le informazioni dell'utente!
}

if (request.getParameter("indietro") != null){
	response.sendRedirect("index.jsp");
}


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
                    <li>
                        <a class="forget" data-toggle="modal" data-target=".forget-modal-logout" href="#modalLogout" >Logout</a>
                    </li>
                     <li>
                        <a class="page-scroll" href="profilo.jsp">Profilo</a>
                    </li>
                  
                    <%if (us.getType()==2){ %>
                     <li>
                        <a class="page-scroll" href="prova.jsp">Tuoi acquisti</a>
                    </li>
                     <li>
                        <a class="page-scroll" href="prova.jsp">Carrello</a>
                    </li>
                   
                    <%}else if (us.getType()==1) { %>
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



 <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">Puoi modificare il tuo profilo qui sotto!</div>
            </div>
        </div>
    </header>
    
    <%
    
    String email = us.getEmail();
    String userid = us.getUserid();
    
    String type = "Sconosciuto";
   
    if (us.getType()==1) type = "Venditore";
    else if (us.getType()==2){
    	if (us.isEnteB()) type = "Ente";
    	else type = "Consumatore";
    }
    
    
    
    %>
    
     <div class="container">
     <font size="6">Profilo di <%= userid%> ( <%= email%>,  <%= type%>) </font> 
  	<hr>
      
      <!-- edit form column -->
        <font size="2">*Le informazioni lasciate in bianco non saranno aggiornate</font> <br> <br> 
        
        <form name="modificaInfo" id="modificaInfoForm" class="form-horizontal" role="form" action="profilo.jsp" method="post">
          <div class="form-group">
            <label class="col-lg-3 control-label">Nome:</label>
            <div class="col-lg-8">
              <input class="form-control"  value=<%= updatebean.getName()%> type="text" id="nameModifica" name="name">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Cognome:</label>
            <div class="col-lg-8">
              <input class="form-control" value=<%= updatebean.getSurname()%> type="text" id="surnameModifica" name="surname">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Via:</label>
            <div class="col-lg-8">
              <input class="form-control" value=<%= updatebean.getStreet()%> type="text" id="streetModifica" name="street">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Telefono:</label>
            <div class="col-lg-8">
              <input class="form-control" value=<%= updatebean.getTelephone()%> type="text" id="telephoneModifica" name="telephone">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">New password:</label>
            <div class="col-lg-8">
              <input class="form-control" value=<%= updatebean.getPassword()%>  type="password" id="passwordModifica" name="password">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Confirm new password:</label>
            <div class="col-lg-8">
              <input class="form-control" value=<%= updatebean.getPassword()%> type="password" id="rippasswordModifica" name="rippassword">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <button type="submit" class="btn btn-xl" name="salvaInfo" value="salvaInfo">Invia</button>
              <span></span>
              <button type="submit" class="btn btn-xl" name="indietro" value="indietro">Indietro</button>
            </div>
          </div>
        </form>
        
        <font color="red"><%=errorMessage%></font>
		<hr>
		</div>
		
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
		

   

	<footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Copyright &copy; Your Website 2016</span>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline quicklinks">
                         <li><a href="#" style="float:right">Regolamento</a>
                        </li>
                        <li><a href="#" style="float:right">Contattaci</a>
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
    