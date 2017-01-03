<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma2.ispw.bean.*" %>
<%@ page import="it.uniroma2.ispw.controller.*" %>
<%@ page import="it.uniroma2.ispw.model.*" %>
<%@ page import="it.uniroma2.ispw.session.*" %>




<jsp:useBean id="loginb" scope="session" class="it.uniroma2.ispw.bean.LoginBean"/>
<jsp:setProperty name="loginb" property="*"/>

<jsp:useBean id="regb" scope="session" class="it.uniroma2.ispw.bean.RegistrazioneBean"/>
<jsp:setProperty name="regb" property="*"/>

<%
if(request.getParameter("accedi") != null){
	
	UtenteSessione us = loginb.validate();
	if(us != null){
			
		
			//vai alla homepage registrata
			
			session.setAttribute("utente",us);
			response.sendRedirect("indexPageR.jsp");
	}else{
		%>
	
	<script type="text/javascript">
		$('#modalErrLogin').modal('show')
	</script>
	
	<%	
	}
}

if(request.getParameter("invia") != null){
	
	out.println("we");

}
%>

<%
	if(request.getParameter("invia") != null){
		if(regb.effettuaRegistrazione() == true){
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("registrazione.jsp");
		}
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
                <a class="navbar-brand page-scroll" href="index.jsp">Shopping Express</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="forget" data-toggle="modal" data-target=".forget-modal-login" href="#modalLogin">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#team">Regolamento</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>


<!--popup login-->
	<div id="modalLogin" class="modal fade forget-modal-login" tabindex="-1" role="dialog" aria-labelledby="myLoginModalLabel" aria-hidden="true" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">x</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">Login</h4>
					</div>	
					<div class="modal-body">
						<div class="form-wrap">
							<form action="upload.jsp" method="post">
								<div class="form-group">
									<label for="usernameLogin" class="sr-only">Username</label>
									<input type="text" id="email" name="email" class="form-control" placeholder="Username">
								</div>
								<div class="form-group">
									<label for="usernameLogin" class="sr-only">Password</label>
									<input type="password" id="password" name="password" class="form-control" placeholder="Password">
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<input class="btn btn-custom" type="submit" id="btn-login" name="accedi" value="accedi">
					</div>
				</div>
			</div>
	</div>	




<!--popup login non riuscito-->
	<div id="modalErrlogin" class="modal fade forget-modal-errlogin" tabindex="-1" role="dialog" aria-labelledby="myLoginModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">x</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">Errore</h4>
					</div>	
					<div class="modal-body">
						<p>Errore nell'inserimento dei dati per il login, riprovare!</p>					
					</div>
					<div class="modal-footer">			
						<input class="btn btn-custom" type="submit" id="btn-logout" name="ok" value="ok">
					</div>
				</div>
			</div>
	</div>	




    <!-- Contact Section -->
    <section id="registrazione">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Registrazione</h2>
					<p class="help-block text-danger"> </p>
				</div>
            </div>
            <div class="row text-center">
                <div class="col-lg-12">
                    <form name="registrazione" id="registrazioneForm" action="registrazione.jsp" method="post">
                    <div class="row">
                    		<div class="form-group">
								<input type="text" id="useridRegistrazione" placeholder="Userid" name="userid" class="form-control">
                                <p class="help-block text-danger"></p>
                            </div>
							<div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" id="nomeRegistrazione" placeholder="Nome" name="name" class="form-control" >
                                    <p class="help-block text-danger"></p>
                                </div>
							</div>
							<div class="col-md-6">
                                <div class="form-group">
                                <input type="text" id="cognomeRegistazione" placeholder="Cognome" name="surname" class="form-control">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
							<div class="form-group">
								<input type="text" id="emailRegistrazione" placeholder="Email" name="email" class="form-control">
                                <p class="help-block text-danger"></p>
                            </div>
							<div class="form-group">
								<input type="password" id="passwordRegistrazione" placeholder="Password" name="password" class="form-control">
                                <p class="help-block text-danger"></p>
                            </div>
							<div class="form-group">
								<input type="password" id="rippasswordRegistrazione" placeholder="Ripeti Password" name="rippassword" class="form-control">
                                <p class="help-block text-danger"></p>
                            </div>
							<div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" id="telefonoRegistrazione" placeholder="Telefono" name="telephone" class="form-control">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
							<div class="form-group">
								<input type="text" id="indirizzoRegistrazione" placeholder="Indirizzo" name="street" class="form-control">
                                <p class="help-block text-danger"></p>
                            </div>
							<div class="checkbox">
								<label>
									<input type="checkbox" name="regCheck" id="check_value" class="text-primary"><font color="white">Ho letto e accettato il regolamento</font> <br>
									<input type="radio" value="Venditore" name="type" id="check_value" class="text-primary"> <font color="white">Venditore</font> <br>
									<input type="radio" value="Consumatore" name="type" id="check_value" class="text-primary"><font color="white">Consumatore</font> <br>
								</label>
							</div>
            
							<div class="clearfix"></div>
                            <div class="col-lg-12 text-center">
                                <div id="success"></div>
                                <button type="submit" class="btn btn-xl" name="invia" value="invia">Invia</button>
                            </div>
							
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
	

<!--popup errore registrazione-->
    <div id="modalErroreReg" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLoginModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">x</span>
					<span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">Errore</h4>
			</div>	
			<div class="modal-body">
				<p>Registrazione fallita, riprovare!</p>
			</div>
			<div class="modal-footer">
				<input class="btn btn-custom" type="submit" id="btn-ok" name="ok" value="ok">
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
