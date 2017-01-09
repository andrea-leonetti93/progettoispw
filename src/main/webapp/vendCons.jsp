<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma2.ispw.bean.*" %>
<%@ page import="it.uniroma2.ispw.controller.*" %>
<%@ page import="it.uniroma2.ispw.model.*" %>
<%@ page import="java.util.*" %>


<jsp:useBean id="utente" scope="session" class="it.uniroma2.ispw.bean.UtenteBean"/>
<jsp:setProperty name="utente" property="*"/>
<jsp:useBean id="insProdotto" class="it.uniroma2.ispw.bean.InsProdottoBean"/>
<jsp:setProperty name="insProdotto" property="*"/>

<%

UtenteBean u = (UtenteBean) session.getAttribute("utente");
%>

<%
	if(request.getParameter("addProduct") != null){
		/*carica categoria da db*/
	}
%>

<% 
	if(request.getParameter("allow") != null){
		insProdotto.setUtente(u);
		if(insProdotto.acquisisciProdotto()){
			response.sendRedirect("vendCons.jsp");
		}else{
			System.out.println("errore inserimento prodotto");
		}
	}
%>

<%
	if(request.getParameter("delete") != null){
		//String id = request.getParameter("idProd");
		//int foo = Integer.parseInt(id);
		//System.out.println("valore idProd" + " " +insProdotto.getIdProd() + " " + id);
		if(insProdotto.eliminaProdotto()){
			response.sendRedirect("vendCons.jsp");
		}else{
			System.out.println("errore eliminazione prodotto");
		}
	}
%>

<%
	if(request.getParameter("change") != null){
		if(insProdotto.trovaProdotto() == false){
			System.out.println("prodotto non trovato");
		}
		//notifica?
	}
%>

<%
	if(request.getParameter("addChanges") != null){
		insProdotto.setUtente(u);
		if(insProdotto.modificheProdotto()){
			response.sendRedirect("vendCons.jsp");
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
                        <a class="forget" data-toggle="modal" data-target=".forget-modal-logout" href="#modalLogout" >Logout</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="prova.jsp">Profilo</a>
                    </li>
                    
                     <%if (u.getType().equals("Consumatore")){ %>
                     <li>
                        <a class="page-scroll" href="prova.jsp">Tuoi annunci</a>
                    </li>
                    <%}else { %>
                     <li>
                        <a class="page-scroll" href="prova.jsp">Carrello</a>
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
					
					<form action="prova.jsp" method="post">		
						<input class="btn btn-custom" type="submit" id="btn-logout" name="ok" value="ok">
					</form>
					</div>
				</div>
			</div>
	</div>	

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                
                
                <div class="intro-lead-in">Bentornato nel nostro sito di e-commerce, <%= utente.getName() %>!</div>
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
							<input type="text" id="nameProduct" name="nameProduct" class="form-control" placeholder="Name">
						</div>					
						<div class="form-group">
							<label for="categoriaAdd" class="form-control-label">Category</label>
							<select class="form-control" id="selectCategory" name="category" onchange="giveSelection(this.value)">
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
							<label for="amountAdd" class="form-control-label">Amount</label>
							<input type="text" id="amount" name="amount" class="form-control" placeholder="Amount">
						</div>
						<div class="form-group">
							<label for="priceAdd" class="form-control-label">Price</label>
							<input type="text" id="price" name="price" class="form-control" placeholder="Price">
						</div>
						<div class="form-group">
							<label for="methodPayAdd" class="form-control-label">Pay Method</label>
							<input type="text" id="methodPay" name="methodPay" class="form-control" placeholder="Pay method">
						</div>
						<div class="form-group">
							<label for="deliveryTypeAdd" class="form-control-label">Delivery type</label>
							<input type="text" id="deliveryType" name="deliveryType" class="form-control" placeholder="Delivery type">
						</div>
						<div class="form-group">
							<label for="saleAdd" class="form-control-label">Sale</label>
							<input type="text" id="sale" name="sale" class="form-control" placeholder="Sale">
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
							<input type="text" id="nomeProd" name="nomeProd" class="form-control" value="{{ request.form.nomeProd }}">
						</div>
						<div class="form-group">
							<label for="nameAdd" class="form-control-label">IdProd</label>
							<input type="text" id="idProd" name="idProd" class="form-control" value="{{ request.form.idProd }}" readonly>
						</div>						
						<div class="form-group">
							<label for="categoriaAdd" class="form-control-label">Category</label>
							<input type="text" id="cate" name="cate" class="form-control" value="{{ request.form.cate }}" readonly>
						</div>
						<div class="form-group">
							<label for="typologyAdd" class="form-control-label">Typology</label>
							<input type="text" id="tipo" name="tipo" class="form-control" value="{{ request.form.tipo }}" readonly>
						</div>
						<div class="form-group">
							<label for="amountAdd" class="form-control-label">Amount</label>
							<input type="text" id="quant" name="quant" class="form-control" value="{{ request.form.quant }}">
						</div>
						<div class="form-group">
							<label for="priceAdd" class="form-control-label">Price</label>
							<input type="text" id="prezzo" name="prezzo" class="form-control" value="{{ request.form.prezzo }}">
						</div>
						<div class="form-group">
							<label for="methodPayAdd" class="form-control-label">Pay Method</label>
							<input type="text" id="metodPag" name="metodPag" class="form-control" value="{{ request.form.metodPag }}">
						</div>
						<div class="form-group">
							<label for="deliveryTypeAdd" class="form-control-label">Delivery type</label>
							<input type="text" id="tipoCons" name="tipoCons" class="form-control" value="{{ request.form.tipoCons }}">
						</div>
						<div class="form-group">
							<label for="saleAdd" class="form-control-label">Sale</label>
							<input type="text" id="sconto" name="sconto" class="form-control" value="{{ request.form.sconto }}">
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
	if(u.getType().equals("Venditore")){
		insProdotto.riempiLista(u.getEmail());
%>
   
   <section id="prodotti">
   		<div class = "container">
   			<div class="row text-center">
   				<div class="header">
   					<h2 class="title">I tuoi prodotti</h2>
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
   						<form method="post" id="inserzione-prodotto">		<!-- action="{{ url_for('modalChangeProduct') }}" -->
   						<div class="header">
   							<div class="form-group">
   								<h3>Prodotto: <input type="text" value="<%= p.getNome() %>" id="nomeProd-init" name="nomeProd" readonly></h3>
   								<h5>IdProdotto:<input class="btn btn-custom" type="text" id="idProd-init" name="idProd" value="<%= p.getId() %>" readonly></h5>
							</div>
						</div>
						<div class="body">
								<ul class="list-group">
									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Categoria: </span> <input type="text" value="<%= p.getCategoria() %>" id="cate-init" data-target="#modalChangeProduct" name="cate" readonly></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Tipologia: </span> <input type="text" value="<%= p.getTipologia() %>" id="tipo-init" data-target="#modalChangeProduct" name="tipo" readonly></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Quantità: </span> <input type="text" value="<%= p.getQuantità() %>" id="quant-init" data-target="#modalChangeProduct" name="quant" readonly></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Prezzo: </span> <input type="text" value="<%= p.getPrezzo() %>" id="prezzo-init" data-target="#modalChangeProduct" name="prezzo" readonly></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Metodo pagamento: </span> <input type="text" value="<%= p.getMetodoPag() %>" id="metodPag-init" data-target="#modalChangeProduct" name="metodPag" readonly></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Tipologia consegna: </span> <input type="text" value="<%= p.getTipoConsegna() %>" id="tipoCons-init" data-target="#modalChangeProduct" name="tipoCons" readonly></li>
   									<li class="list-group-item"><span class="tag tag-default tag-pill float-xs-right">Sconto: </span> <input type="text" value="<%= p.getSconto() %>" id="sconto-init" data-target="#modalChangeProduct" name="sconto" readonly></li>
   								</ul>
   							
   											<p class="help-block text-danger" ></p>
   						</div>
   						<div class="footer">
   							<div class="row">
   								<div class="col-md-3 offset-md-3">
   									<input class="btn btn-primary" type ="submit" id="change_btn" name="change" value="Change" data-toggle="modal" data-target="#modalChangeProduct">
   								</div>
   								<div class="col-md-3 offset-md-3">						
	   								<input class="btn btn-danger" type="submit" name="delete" value="Delete">	
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
<script>
   $('#inserzione-prodotto').on('submit', function(e){
   //$('#change_btn').click(function(){
	e.preventDefault();
	$('#nomeProd').val($('#nomeProd-init').val());
	$('#idProd').val($('#idProd-init').val());
	$('#cate').val($('#cate-init').val());
	$('#tipo').val($('#tipo-init').val());
	$('#quant').val($('#quant-init').val());
	$('#prezzo').val($('#prezzo-init').val());
	$('#metodPag').val($('#metodPag-init').val());
	$('#tipoCons').val($('#tipoCons-init').val());
	$('#sconto').val($('#sconto-init').val());
	$('#modalChangeProduct').modal('show');
});
</script>


</html>



