<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma2.ispw.bean.*" %>
<%@ page import="it.uniroma2.ispw.controller.*" %>
<%@ page import="it.uniroma2.ispw.model.*" %>
<%@ page import="it.uniroma2.ispw.session.*" %>
<%@ page import="java.util.*" %>

<jsp:useBean id="loginb" scope="session" class="it.uniroma2.ispw.bean.LoginBean"/>
<jsp:setProperty name="loginb" property="*"/>
<jsp:useBean id="insProdotto" class="it.uniroma2.ispw.bean.InsProdottoBean"/>
<jsp:setProperty name="insProdotto" property="*"/>

<%

UtenteSessione us = (UtenteSessione) session.getAttribute("utente");

%>

<%
	if(request.getParameter("addProduct") != null){
		/*carica categoria da db*/
	}

	
%>

<% 
	if(request.getParameter("allow") != null){
		insProdotto.setUtente(us);
		if(insProdotto.acquisisciProdotto()==false){

			System.out.println("errore inserimento prodotto");
		}
		
	}
%>

<%
	if(request.getParameter("deleteProd") != null){
		//String id = request.getParameter("idProd");
		//int foo = Integer.parseInt(id);
		//System.out.println("valore idProd" + " " +insProdotto.getIdProd() + " " + id);
		
		int idProd = Integer.parseInt(request.getParameter("idProd")); 
		out.println("Hai scelto di eliminare il prodotto con id= "+ idProd);
		
		if(insProdotto.eliminaProdotto()==false){
			System.out.println("errore eliminazione prodotto");
		}
	}
%>
 
<%
	if(request.getParameter("change") != null){
		int idProd = Integer.parseInt(request.getParameter("idProd")); 
		out.println("Hai scelto di modificare il prodotto con id= "+ idProd);
		if(insProdotto.trovaProdotto() == false){
			System.out.println("prodotto non trovato");
		}
		//notifica?
	}
%>
   
<%
	if(request.getParameter("addChanges") != null){
		insProdotto.setUtente(us);
		if(insProdotto.modificheProdotto()){
			response.sendRedirect("annunci.jsp");
		}else{
			System.out.println("prodotto non modificato");
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
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
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
                   
                    <%if (us.getType()==1) { %>
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

	
<!--popup logout-->	
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



<!--popup conferma delete-->	
	<div id="modalDelete" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLoginModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
				<form action="annunci.jsp" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">x</span>
							<span class="sr-only">Close</span>
						</button>
					
						<h4 class="modal-title">Conferma eliminazione prodotto </h4>
					</div>	
					<div class="modal-body">
						<p>Sicuro di voler eliminare il prodotto?</p>					
					</div>
					<div class="modal-footer">	
					
							
						<input class="btn btn-custom" type="submit" id="btn-deleteProd" name="deleteProd" value="Conferma">
					
					</div>
					</form>
				</div>
			</div>
	</div>	
	
	
    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">Gestione Prodotti di <%=us.getUserid()%>!</div>
            </div>
        </div>
    </header>


<!-- popup aggiungi prodotto -->
	<div id="modalAddProduct" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLoginModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">x</span>
						<span class="sr-only">Close</span>
					</button>
					<h3 class="modal-title">Add Product</h3>
			</div>	
			<div class="modal-body">
				<div class="form-wrap">
					<form action="" method="post">
						<div class="form-group">
							<label for="nameAdd" class="form-control-label">Name</label>
							<input type="text" id="nameProduct" name="nameProduct" class="form-control" placeholder="Name" required data-validation-required-message="Inserire il nome">
						</div>					
						<div class="form-group">
							<label for="categoriaAdd" class="form-control-label">Category</label>
							<select class="form-control" id="selectCategory" name="category" onchange="giveSelection(this.value)" required data-validation-required-message="Scegliere una categoria">
								<option value="x" selected="selected">Select category</option>
								<option value="Elettronica">Elettronica</option>
								<option value="Giardinaggio">Giardinaggio</option>
								<option value="Arredamento">Arredamento</option>
							</select>
						</div>
						<div class="form-group">
							<label for="typologyAdd" class="form-control-label">Typology</label>
							<select class="form-control" id="selectTypology" name="typology">
								<option data-option="x" selected="selected">Select typology</option>
								<option data-option="Elettronica">Cellulari</option>
								<option data-option="Elettronica">Televisori</option>
								<option data-option="Giardinaggio">Taglia erba</option>
								<option data-option="Giardinaggio">Piante</option>
								<option data-option="Arredamento">Tavoli</option>
								<option data-option="Arredamento">Sedie</option>
							</select>
						</div>
						<div class="form-group">
							<label for="priceAdd" class="form-control-label">Price</label>
							<input type="text" id="price" name="price" class="form-control" placeholder="Price" required data-validation-required-message="Inserire il prezzo">
						</div>
						<div class="form-group">
							<label for="saleAdd" class="form-control-label">Sale</label>
							<input type="text" id="sale" name="sale" class="form-control" placeholder="Sale" required data-validation-required-message="Inserire il possibile sconto">
						</div>
						<div class="form-group">
							<label for="commentAdd" class="form-control-label">Description</label>
							<textarea id="comment" name="comment" class="form-control" placeholder="Description" maxlength="255" required data-validation-required-message="Inserire una descrizione"></textarea>
						</div>						
						<div class="modal-footer">
							<input class="btn btn-custom" type="submit" id="btn-login" name="allow" value="allow">
						</div>
					</form>
							
				</div>
						
			</div>
		</div>
				</div>
			</div>

    

<!-- popup modifica prodotto -->
	<div id="modalChangeProduct" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLoginModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">x</span>
						<span class="sr-only">Close</span>
					</button>
					<h3 class="modal-title">Change Product</h3>
			</div>	
			<div class="modal-body">
				<div class="form-wrap">
					<form action="" method="post">
						<div class="form-group">
							<label for="nameAdd" class="form-control-label">Name</label>
							<input type="text" id="nomeProd" name="nameProduct" class="form-control" value="{{ request.form.nomeProd }}" required data-validation-required-message="Inserire il nome">
						</div>
						<div class="form-group">
							<label for="idAdd" class="form-control-label">IdProd</label>
							<input type="text" id="idProd" name="idProd" class="form-control" value="{{ request.form.idProd }}" readonly>
						</div>						
						<div class="form-group">
							<label for="categoriaAdd" class="form-control-label">Category</label>
							<input type="text" id="cate" name="category" class="form-control" value="<%= insProdotto.getCategory() %>" readonly>
						</div>
						<div class="form-group">
							<label for="typologyAdd" class="form-control-label">Typology</label>
							<input type="text" id="tipo" name="typology" class="form-control" value="<%= insProdotto.getTypology() %>" readonly>
						</div>
						<div class="form-group">
							<label for="priceAdd" class="form-control-label">Price</label>
							<input type="text" id="prezzo" name="price" class="form-control" value="<%= insProdotto.getPrice() %>" required data-validation-required-message="Inserire il prezzo">
						</div>
						<div class="form-group">
							<label for="saleAdd" class="form-control-label">Sale</label>
							<input type="text" id="sconto" name="sale" class="form-control" value="<%= insProdotto.getSale() %>" required data-validation-required-message="Inserire il possibile sconto">
						</div>
						<div class="form-group">
							<label for="commentAdd" class="form-control-label">Description</label>
							<textarea id="comment" name="comment" class="form-control" placeholder="Description" maxlength="255" required data-validation-required-message="Inserire la descrizione"></textarea>
						</div>
						<div class="modal-footer">
							<input class="btn btn-custom" type="submit" id="addChanges" name="addChanges" value="Add changes">
						</div>
					</form>
							
				</div>
						
			</div>
		</div>
				</div>
			</div>



<%
	if(us.getType()==1){
		insProdotto.riempiLista(us.getEmail());
%>
   
   <section id="prodotti">
   		<div class = "container">
   			<div class="row text-center">
   				<div class="header">
   					<h2 class="title" id="title">I tuoi prodotti</h2>
   				</div>
   			</div>
   			<div class="body">
   				<div class="row">
   					<input class="btn btn-primary btn-lg btn-block" type="submit" name="addProduct" value="Add Product" data-toggle="modal" data-target="#modalAddProduct">
   				</div>
   				<%
   					List<Prodotto> lp = insProdotto.getArrayProdotti();
   					Prodotto p = null;
   					if(lp.size() != 0){
   						for(int i=0; i<lp.size(); i++){
   							p = lp.get(i);
   				%>		
   					<div class="container">
   					 	<form action="annunci.jsp" method="post" id="inserzione_prodotto">		 <!-- action="{{ url_for('modalChangeProduct') }}" -->
   						<div class="header">
   							<div class="row">
   								<h3>Prodotto: <%= p.getNome() %></h3>
   								<h5>IdProdotto:<input class="btn btn-custom" type="text" id="idProd-init" name="idProd" value="<%= p.getId() %>" readonly></h5>
							</div>
						</div>
						<div class="body">
								<ul class="list-group">
									<li class="list-group-item" id=""><span class="tag tag-default tag-pill float-xs-right">Categoria: </span><%= p.getCategoria() %></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Tipologia: </span><%= p.getTipologia() %></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Prezzo: </span><%= p.getPrezzo() %></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Sconto: </span><%= p.getSconto() %></li>
   								</ul>
   							
   											<p class="help-block text-danger" ></p>
   						</div>
   						<div class="footer">
   							<div class="row">
   								<div class="col-md-3 offset-md-3">
   									<button  type="submit" name="change" value=<%=i %>  class="forget btn btn-primary pull-right">Change</button>
   								</div>
   								<div class="col-md-3 offset-md-3">						
   									<button  type="submit" name="deleteProd" value=<%=i %>  class="btn btn-danger">Delete</button>
	   								
   								</div>
   							</div>
   						
   						</div>
   				 		</form> 
   						<div class="row">
   							<hr>
   						</div>
   						
   					</div>	
   				<% 	
   						}
   					}
   				%>
   				
   			</div>
   		</div>
   </section>
   
<% } %>   

	

<!-- 	
<script type="text/javascript">
$(function myFunction() {
	$('#nomeProd').val($('#nomeProd-init').val());
	$('#idProd').val($('#idProd-init').val());
	$('#modalChangeProduct').modal('show');
});

</script>
    -->

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
    
    <script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
 <script type="text/javascript">
 
 
 $('#inserzione_prodotto').submit( function(e){
	   e.preventDefault();
	   $('#modalChangeProduct').modal('show');	   
	   
 });
 
 	function changeProd(prodottoNum){
 	//	var arrayProd = document.get
 		$('#modalChangeProduct').openModal();
 	}); 
 </script>

</body>


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

<!-- funzione per riempire il modifica prodotto -->
<!-- 
<script type="text/javascript">

$('#change_btn').click( function(){
	$('#nomeProd').val($('#nomeProd-init').val());
	$('#idProd').val($('#idProd-init').val());
	$('#modalChangeProduct').modal('show');

});
   /*$('#inserzione-prodotto').submit(function(e){
	   e.preventDefault();
	});*/
$(document).ready(function(){   
	$(document).on('click', "#change_btn", function(){
	  $('#change_btn').click( function(){	
		$('#nomeProd').val($('#nomeProd-init').val());
		$('#idProd').val($('#idProd-init').val());
		$('#cate').val($('#cate-init').val());
		$('#tipo').val($('#tipo-init').val());
		$('#quant').val($('#quant-init').val());
		$('#prezzo').val($('#prezzo-init').val());
		$('#metodPag').val($('#metodPag-init').val());
		$('#tipoCons').val($('#tipoCons-init').val());
		$('#sconto').val($('#sconto-init').val());
	//$function(e);
		$('#modalChangeProduct').modal('show');
  		});
	});
	
});
	
   
  $('#delete_btn').click(function(){
	$('#idProd').val($('#idProd-init').val());  
	$('#modalDelete').modal('show');
  });
  

</script>

<script type="text/javascript">

$(function myFunction() {
	$('#nomeProd').val($('#nomeProd-init').val());
	$('#idProd').val($('#idProd-init').val());
	$('#modalChangeProduct').modal('show');
});

</script>
 -->


</html>