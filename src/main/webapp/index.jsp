<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma2.ispw.bean.*" %>
<%@ page import="it.uniroma2.ispw.controller.*" %>
<%@ page import="it.uniroma2.ispw.model.*" %>
<%@ page import="it.uniroma2.ispw.session.*" %>
<%@ page import="java.util.*" %>
<%@ page import="it.uniroma2.ispw.persistence.*" %>

<jsp:useBean id="loginb" scope="session" class="it.uniroma2.ispw.bean.LoginBean"/>
<jsp:setProperty name="loginb" property="*"/>

<jsp:useBean id="ricercab" scope="session" class="it.uniroma2.ispw.bean.RicercaBean"/>
<jsp:setProperty name="ricercab" property="*"/>


<%


UtenteSessione us = (UtenteSessione) session.getAttribute("utente");




if(request.getParameter("cerca")!=null){
	
	System.out.println("---");
	System.out.println(ricercab.getNomeRicerca());
	System.out.println(ricercab.getPrezzomax());
	System.out.println("---");
	ricercab.ricercaProdotto();
}

else {
	ricercab.setLpv(null);
}

if(request.getParameter("inviaReg2")!=null){
	
	System.out.println("prova");
	System.out.println(request.getParameter("inviaReg2"));
	
}

if(request.getParameter("accedi") != null){
	String errorMessage;
	errorMessage = loginb.controlloCampi();
	if (errorMessage==null){
		us = loginb.validate();
		if(us != null){
				session.setAttribute("utente",us);
				if(us.getType() == 2){
					CarrelloBean carB = new CarrelloBean();
					session.setAttribute("carrello", carB);
				}
		}else{
			out.println("login fallito");
		}
	}
	else{
		out.println(errorMessage);
	}
}

if(request.getParameter("invia") != null){
	
	out.println("we");
}

if (request.getParameter("logout") != null){

	us = null;
	session.invalidate();
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
                        <a class="page-scroll" href="visualizzaVendite.jsp">Tue Vendite</a>
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
    
    	<%
								
			TipoProdottoDAO tpdao = new TipoProdottoDAO();
								
			List<TipoProdotto> ltp = tpdao.listaTipiProdotto();
			List<String> listaCategorie = new ArrayList<String>();
								
			for (TipoProdotto tp : ltp){
				listaCategorie.add(tp.getCategoria());
			}
								
			//Elimina Doppioni Categorie
			Set<String> se = new HashSet<String>(listaCategorie);
			listaCategorie.clear();
			listaCategorie = new ArrayList<String>(se);
								
		%>							

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
					<form action="index.jsp" method="post" name="cerca" id="ricercaForm">
						<div class="row">
							 <div class="form-group">
           				 		<label class="col-lg-3 control-label">Categoria:</label>
            					
              				<div class="form-group">
							<select class="form-control" id="selectCategory" name="categoria" onchange="giveSelection(this.value)">
								<option value="x" selected="selected">Select category</option>
								<%for (String categoria : listaCategorie) {%>

									<option value="<%= categoria %>"><%= categoria %></option>
								
								<%} %>
							</select>
						</div>
						<label class="col-lg-3 control-label">Tipologia:</label>
						<div class="form-group">
							<select class="form-control" id="selectTypology" name="tipologia">
								<option data-option="x" selected="selected">Select typology</option>
								<%for (TipoProdotto tp : ltp){%>
									<option data-option="<%= tp.getCategoria() %>"><%=tp.getTipologia() %></option>
								<%} %>
								</select>
            					</div>
            				</div>	
          					</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Nome prodotto" name="nomeRicerca"  id="nomeprodotto" >
								<p class="help-block text-danger" ></p>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Prezzo min" name="prezzomin" id="prezzomin" >
									<p class="help-block text-danger" ></p>									
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Prezzo max" name="prezzomax"  id="prezzomax" >
									<p class="help-block text-danger" ></p>									
								</div>
							</div>
							<div class="form-group">
								<input type="submit" class="btn-xl" id="btncerca" name="cerca" value="cerca">
								<p class="help-block text-danger"></p>							
							</div>
							
					</form>
                </div>
                </div>
            </div>
        
    </section>
    
    <%
   
    if (ricercab.getLpv()!=null){
    	for(int i=0;i<ricercab.getLpv().size();i++){
    	
    
    %>
    	
    	    <!-- Project One -->
        <div class="row">
           
            </div>
            <div class="col-md-9">
                <h3><%= ricercab.getLpv().get(i).getP().getNome() %></h3>
                <h4 class="pull-right">$<%=ricercab.getLpv().get(i).getPrezzoFinale()%></h4>
                <h4><%= ricercab.getLpv().get(i).getV().getUserid()%></h4>
                <p><%= ricercab.getLpv().get(i).getP().getCommento() %></p>
             
              <form action="visualizzaAnnuncio.jsp" method="post">
 			<input type="hidden" class="form-control" name="i" value=<%= i%>  id="nomeprodotto" >
 			<button  type="submit" name="visualizzaProdotto" value="ttt"  class="btn-primary">Vedi Prodotto</button>
				</form>
            
        </div>
        <!-- /.row -->
    	
    	
    <%} }%>
    
       
    
	
	
   

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
    
    
    
    <script>
$(function() {
    var temp="x"; 
    $("#selectCategory").val(temp);
});
</script>
<script type="text/javascript">
   var sel1 = document.querySelector('#selectCategory');
   var sel2 = document.querySelector('#selectTypology');
   var options2 = sel2.querySelectorAll('option');
   function giveSelection(selValue) {
      sel2.innerHTML = '';
      for(var i=0; i<options2.length; i++){
	 if(options2[i].dataset.option === selValue){
	    sel2.appendChild(options2[i]);
	 }
      }
   }
   giveSelection(sel1.value);
</script>
<!-- funzione per appendere elemento dinamicamente ad una lista -->
<script type="text/javascript">
	var num = 1;
	function elimina_elemento () {
			$("#menu").append("<li>nuovo elemento "+num+"</li>");
			num++;
	}
</script>

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
