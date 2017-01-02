<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma2.ispw.bean.*" %>
<%@ page import="it.uniroma2.ispw.controller.*" %>
<%@ page import="it.uniroma2.ispw.model.*" %>


<jsp:useBean id="utente" scope="session" class="it.uniroma2.ispw.bean.UtenteBean"/>
<jsp:setProperty name="utente" property="*"/>

<%
	if(request.getParameter("accedi") != null){
		
		if(utente.validate()){
				
				//vai alla homepage registrata
				session.setAttribute("utente",utente);
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
                        <a class="page-scroll" href="#ricerca">Cerca prodotto</a>
                    </li>
                    <li>
                        <a class="forget" data-toggle="modal" data-target=".forget-modal-login" href="#modalLogin">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="registrazione.jsp">Registrazione</a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

<!-- popup login -->
	<div id="modalLogin" class="modal fade forget-modal-login" tabindex="-1" role="dialog" aria-labelledby="myLoginModalLabel" aria-hidden="true">
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
						<form action="index.jsp" method="post">
								<div class="form-group">
									<label for="usernameLogin" class="sr-only">Username</label>
									<input type="text" id="email" name="email" class="form-control" placeholder="Username">
								</div>
								<div class="form-group">
									<label for="usernameLogin" class="sr-only">Password</label>
									<input type="password" id="password" name="password" class="form-control" placeholder="Password">
								</div>
								<div class="modal-footer">
									<input class="btn btn-custom" type="submit" id="btn-login" name="accedi" value="accedi">
								</div>
							</form>
							
						</div>
						
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



    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">Benvenuto nel nostro sito di e-commerce!</div>
                <div class="intro-heading">It's Nice To Meet You</div>
            </div>
        </div>
    </header>

    <!-- Services Section -->
    <section id="ricerca">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Ricerca Prodotto</h2>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-lg-12">
					<form name="cerca" id="ricercaForm">
						<div class="row">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Categoria"  id="categoria" >
								<p class="help-block text-danger" ></p>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Tipologia"  id="tipologia" >
								<p class="help-block text-danger" ></p>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Nome prodotto"  id="nomeprodotto" >
								<p class="help-block text-danger" ></p>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Prezzo min"  id="prezzomin" >
									<p class="help-block text-danger" ></p>									
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Prezzo max"  id="prezzomax" >
									<p class="help-block text-danger" ></p>									
								</div>
							</div>
							<div class="form-group">
								<input type="button" class="btn-xl" id="btncerca" value="cerca">
								<p class="help-block text-danger"></p>							
							</div>
						</div>	
					</form>
                </div>
            </div>
        </div>
    </section>
    
         <!-- Project One -->
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img class="img-responsive" src="http://placehold.it/700x300" alt="">
                </a>
            </div>
            <div class="col-md-5">
                <h3>Project One</h3>
                <h4>Subheading</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium veniam exercitationem expedita laborum at voluptate. Labore, voluptates totam at aut nemo deserunt rem magni pariatur quos perspiciatis atque eveniet unde.</p>
                <a class="btn btn-primary" href="#">View Project <span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Project Two -->
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img class="img-responsive" src="http://placehold.it/700x300" alt="">
                </a>
            </div>
            <div class="col-md-5">
                <h3>Project Two</h3>
                <h4>Subheading</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, odit velit cumque vero doloremque repellendus distinctio maiores rem expedita a nam vitae modi quidem similique ducimus! Velit, esse totam tempore.</p>
                <a class="btn btn-primary" href="#">View Project <span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
        <!-- /.row -->

        <hr>

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
    
    
    <div class="container">
    <h1>Edit Profile</h1>
  	<hr>
	<div class="row">
      <!-- left column -->
      <div class="col-md-3">
        <div class="text-center">
          <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
          <h6>Upload a different photo...</h6>
          
          <input class="form-control" type="file">
        </div>
      </div>
      
      <!-- edit form column -->
      <div class="col-md-9 personal-info">
        <div class="alert alert-info alert-dismissable">
          <a class="panel-close close" data-dismiss="alert">×</a> 
          <i class="fa fa-coffee"></i>
          This is an <strong>.alert</strong>. Use this to show important messages to the user.
        </div>
        <h3>Personal info</h3>
        
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label class="col-lg-3 control-label">First name:</label>
            <div class="col-lg-8">
              <input class="form-control" value="Jane" type="text">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Last name:</label>
            <div class="col-lg-8">
              <input class="form-control" value="Bishop" type="text">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Company:</label>
            <div class="col-lg-8">
              <input class="form-control" value="" type="text">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Email:</label>
            <div class="col-lg-8">
              <input class="form-control" value="janesemail@gmail.com" type="text">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Time Zone:</label>
            <div class="col-lg-8">
              <div class="ui-select">
                <select id="user_time_zone" class="form-control">
                  <option value="Hawaii">(GMT-10:00) Hawaii</option>
                  <option value="Alaska">(GMT-09:00) Alaska</option>
                  <option value="Pacific Time (US &amp; Canada)">(GMT-08:00) Pacific Time (US &amp; Canada)</option>
                  <option value="Arizona">(GMT-07:00) Arizona</option>
                  <option value="Mountain Time (US &amp; Canada)">(GMT-07:00) Mountain Time (US &amp; Canada)</option>
                  <option value="Central Time (US &amp; Canada)" selected="selected">(GMT-06:00) Central Time (US &amp; Canada)</option>
                  <option value="Eastern Time (US &amp; Canada)">(GMT-05:00) Eastern Time (US &amp; Canada)</option>
                  <option value="Indiana (East)">(GMT-05:00) Indiana (East)</option>
                </select>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Username:</label>
            <div class="col-md-8">
              <input class="form-control" value="janeuser" type="text">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Password:</label>
            <div class="col-md-8">
              <input class="form-control" value="11111122333" type="password">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Confirm password:</label>
            <div class="col-md-8">
              <input class="form-control" value="11111122333" type="password">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <input class="btn btn-primary" value="Save Changes" type="button">
              <span></span>
              <input class="btn btn-default" value="Cancel" type="reset">
            </div>
          </div>
        </form>
      </div>
  </div>
</div>
<hr>

   

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
