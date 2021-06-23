<%-- 
    Document   : index
    Created on : 27/06/2019, 01:00:04 PM
    Author     : David
--%>

<!-- libreria JSTL Core -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- librería Tag Security -->
<%@taglib prefix="security" 
          uri="http://www.springframework.org/security/tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    
   <head>
   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Little Closet template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css" rel="stylesheet" type="text/css"/>
        <link href="resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css" rel="stylesheet" type="text/css"/>
        <link href="resources/plugins/OwlCarousel2-2.2.1/animate.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/main_styles.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/responsive.css" rel="stylesheet" type="text/css"/>
        <c:url  var="ruta" value="/resources/images"/>
    </head>
    
    <body >
       
        <div class="menu">

	<!-- Search -->
	<div class="menu_search">
		<form action="#" id="menu_search_form" class="menu_search_form">
			<input type="text" class="search_input" placeholder="Search Item" required="required">
			<button class="menu_search_button"><img src="resources/images/search.png" alt=""/></button>
                        
		</form>
            
	</div>
	<!-- Navigation -->
	<div class="menu_nav">
		<ul>
			<li><a href="#">Lacteos</a></li>
			<li><a href="#">Embutidos</a></li>
			<li><a href="#">Bebidas</a></li>
			<li><a href="#">Cereales</a></li>
			
		</ul>
	</div>
	<!-- Contact Info -->
	
</div>
        <div class="super_container">
            <!-- Header -->

	<header class="header">
		<div class="header_overlay"></div>
		<div class="header_content d-flex flex-row align-items-center justify-content-start">
			<div class="logo">
				<a href="#">
					<div class="d-flex flex-row align-items-center justify-content-start">
						<div><img src="resources/images/logo_1.png" alt=""></div>
						<div>Productos</div>
					</div>
				</a>	
			</div>
			<div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
			<nav class="main_nav">
				<ul class="d-flex flex-row align-items-start justify-content-start">
					<li class="active"><a href="">Lacteos</a></li>
					<li><a href="">Bebidas</a></li>
					<li><a href="">Embutidos</a></li>
					<li><a href="">Cereales</a></li>
				</ul>
			</nav>
			<div class="header_right d-flex flex-row align-items-center justify-content-start ml-auto">
				
				<!-- User -->
				<div class="user"><a href="login"><div><img src="resources/images/user.svg" alt="https://www.flaticon.com/authors/freepik"><div>1</div></div></a></div>
				<!-- Cart -->
				<div class="cart"><a href=""><div><img class="svg" src="resources/images/cart.svg" alt="https://www.flaticon.com/authors/freepik"></div></a></div>
				
			</div>
		</div>
	</header>
            <!--aaaaa-->
            <div class="super_container_inner">
		<div class="super_overlay"></div>

		<!-- Home -->

		<div class="home">
			<!-- Home Slider -->
			<div class="home_slider_container">
				<div class="owl-carousel owl-theme home_slider">
					
					<!-- Slide -->
					<div class="owl-item">
						<div class="background_image" style="background-image:url(resources/images/fondoI.jpg)"></div>
						<div class="container fill_height">
							<div class="row fill_height">
								<div class="col fill_height">
									<div class="home_container d-flex flex-column align-items-center justify-content-start">
										<div class="home_content">
											<div class="home_title">HAZ UNA VENTA</div>
											<div class="home_subtitle">NO UN CLIENTE</div>
											<div class="home_items">
												<div class="row">
													<div class="col-sm-3 offset-lg-1">
														<div class="home_item_side"><a href="#"><img src="resources/images/pro1.jpg" alt=""></a></div>
													</div>
													<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">
														<div class="product home_item_large">
															<div class="product_tag d-flex flex-column align-items-center justify-content-center">
																<div>
																	<div>Pack</div>
																	<div>s/15<span>.99</span></div>
																</div>
															</div>
															<div class="product_image"><img src="resources/images/pro2.jpg" alt=""></div>
															<div class="product_content">
																<div class="product_info d-flex flex-row align-items-start justify-content-start">
																	<div>
																		<div>
																			<div class="product_name"><a href="#">Nescafe</a></div>
																			<div class="product_category"><a href="#">Categoria</a></div>
																		</div>
																	</div>
																	<div class="ml-auto text-right">
																		<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
																		<div class="product_price text-right">s/15<span>.99</span></div>
																	</div>
																</div>
																<div class="product_buttons">
																	<div class="text-right d-flex flex-row align-items-start justify-content-start">
																		<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
																			<div><div><img src="resources/images/heart.svg" alt=""><div>+</div></div></div>
																		</div>
																		<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
																			<div><div><img src="resources/images/cart_2.svg" alt=""><div>+</div></div></div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="col-sm-3">
														<div class="home_item_side"><a href="#"><img src="resources/images/pro3.jpg" alt=""></a></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>	
					</div>

					<!-- Slide -->
					<div class="owl-item">
						<div class="background_image" style="background-image:url(resources/images/fondoI.jpg)"></div>
						<div class="container fill_height">
							<div class="row fill_height">
								<div class="col fill_height">
									<div class="home_container d-flex flex-column align-items-center justify-content-start">
										<div class="home_content">
											<div class="home_title">HAZ UNA VENTA</div>
											<div class="home_subtitle">NO UN CLIENTE</div>
											<div class="home_items">
												<div class="row">
													<div class="col-sm-3 offset-lg-1">
														<div class="home_item_side"><a href="#"><img src="resources/images/pro4.jpg" alt=""></a></div>
													</div>
													<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">
														<div class="product home_item_large">
															<div class="product_tag d-flex flex-column align-items-center justify-content-center">
																<div>
																	<div>Pack</div>
																	<div>s/5<span>.99</span></div>
																</div>
															</div>
															<div class="product_image"><img src="resources/images/pro5.jpg" alt=""></div>
															<div class="product_content">
																<div class="product_info d-flex flex-row align-items-start justify-content-start">
																	<div>
																		<div>
																			<div class="product_name"><a href="">HOT DOG</a></div>
																			<div class="product_category"><a href="">Categoria</a></div>
																		</div>
																	</div>
																	<div class="ml-auto text-right">
																		<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
																		<div class="product_price text-right">s/5<span>.99</span></div>
																	</div>
																</div>
																<div class="product_buttons">
																	<div class="text-right d-flex flex-row align-items-start justify-content-start">
																		<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
																			<div><div><img src="resources/images/heart.svg" alt=""><div>+</div></div></div>
																		</div>
																		<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
																			<div><div><img src="resources/images/cart_2.svg" alt=""><div>+</div></div></div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="col-sm-3">
														<div class="home_item_side"><a href=""><img src="resources/images/pro6.jpg" alt=""></a></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>	
					</div>

					<!-- Slide -->
					<div class="owl-item">
						<div class="background_image" style="background-image:url(resources/images/fondoI.jpg)"></div>
						<div class="container fill_height">
							<div class="row fill_height">
								<div class="col fill_height">
									<div class="home_container d-flex flex-column align-items-center justify-content-start">
										<div class="home_content">
											<div class="home_title">HAZ UNA VENTA</div>
											<div class="home_subtitle">NO UN CLIENTE</div>
											<div class="home_items">
												<div class="row">
													<div class="col-sm-3 offset-lg-1">
														<div class="home_item_side"><a href=""><img src="resources/images/pro1.jpg" alt=""></a></div>
													</div>
													<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">
														<div class="product home_item_large">
															<div class="product_tag d-flex flex-column align-items-center justify-content-center">
																<div>
																	<div>Pack</div>
																	<div>s/15<span>.99</span></div>
																</div>
															</div>
															<div class="product_image"><img src="resources/images/pro2.jpg" alt=""></div>
															<div class="product_content">
																<div class="product_info d-flex flex-row align-items-start justify-content-start">
																	<div>
																		<div>
																			<div class="product_name"><a href="#">Nescafe</a></div>
																			<div class="product_category"><a href="#">Categoria</a></div>
																		</div>
																	</div>
																	<div class="ml-auto text-right">
																		<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
																		<div class="product_price text-right">s/15<span>.99</span></div>
																	</div>
																</div>
																<div class="product_buttons">
																	<div class="text-right d-flex flex-row align-items-start justify-content-start">
																		<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
																			<div><div><img src="images/heart.svg" alt=""><div>+</div></div></div>
																		</div>
																		<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
																			<div><div><img src="images/cart_2.svg" alt=""><div>+</div></div></div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="col-sm-3">
														<div class="home_item_side"><a href=""><img src="resources/images/pro6.jpg" alt=""></a></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>	
					</div>

					<!-- Slide -->
					<div class="owl-item">
						<div class="background_image" style="background-image:url(resources/images/fondoI.jpg)"></div>
						<div class="container fill_height">
							<div class="row fill_height">
								<div class="col fill_height">
									<div class="home_container d-flex flex-column align-items-center justify-content-start">
										<div class="home_content">
											<div class="home_title">HAZ UNA VENTA</div>
											<div class="home_subtitle">NO UN CLIENTE</div>
											<div class="home_items">
												<div class="row">
													<div class="col-sm-3 offset-lg-1">
														<div class="home_item_side"><a href=""><img src="resources/images/pro4.jpg" alt=""></a></div>
													</div>
													<div class="col-lg-4 col-md-6 col-sm-8 offset-sm-2 offset-md-0">
														<div class="product home_item_large">
															<div class="product_tag d-flex flex-column align-items-center justify-content-center">
																<div>
																	<div>Pack</div>
																	<div>s/10<span>.99</span></div>
																</div>
															</div>
															<div class="product_image"><img src="resources/images/pro3.jpg" alt=""></div>
															<div class="product_content">
																<div class="product_info d-flex flex-row align-items-start justify-content-start">
																	<div>
																		<div>
																			<div class="product_name"><a href="">Leche</a></div>
																			<div class="product_category"><a href="">Categoria</a></div>
																		</div>
																	</div>
																	<div class="ml-auto text-right">
																		<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
																		<div class="product_price text-right">s/10<span>.99</span></div>
																	</div>
																</div>
																<div class="product_buttons">
																	<div class="text-right d-flex flex-row align-items-start justify-content-start">
																		<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
																			<div><div><img src="images/heart.svg" alt=""><div>+</div></div></div>
																		</div>
																		<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
																			<div><div><img src="images/cart_2.svg" alt=""><div>+</div></div></div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="col-sm-3">
														<div class="home_item_side"><a href=""><img src="resources/images/pro1.jpg" alt=""></a></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>	
					</div>

				</div>
				<div class="home_slider_nav home_slider_nav_prev"><i class="fa fa-chevron-left" aria-hidden="true"></i></div>
				<div class="home_slider_nav home_slider_nav_next"><i class="fa fa-chevron-right" aria-hidden="true"></i></div>

				<!-- Home Slider Dots -->
				
				<div class="home_slider_dots_container">
					<div class="container">
						<div class="row">
							<div class="col">
								<div class="home_slider_dots">
									<ul id="home_slider_custom_dots" class="home_slider_custom_dots d-flex flex-row align-items-center justify-content-center">
										<li class="home_slider_custom_dot active">01</li>
										<li class="home_slider_custom_dot">02</li>
										<li class="home_slider_custom_dot">03</li>
										<li class="home_slider_custom_dot">04</li>
									</ul>
								</div>
							</div>
						</div>
					</div>	
				</div>

			</div>
		</div>

		<!-- Products -->

		<div class="products">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 offset-lg-3">
						<div class="section_title text-center">Productos</div>
					</div>
				</div>
				<div class="row page_nav_row">
					<div class="col">
						<div class="page_nav">
							<ul class="d-flex flex-row align-items-start justify-content-center">
								<li class="active"><a href="">Lacteos</a></li>
								<li><a href="">Bebidas</a></li>
								<li><a href="">Embutidos</a></li>
								<li><a href="">Cereales</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row products_row">
					
					<!-- Product -->
					<div class="col-xl-4 col-md-6">
						<div class="product">
							<div class="product_image"><img src="resources/images/catalogo1.jpg" alt=""></div>
							<div class="product_content">
								<div class="product_info d-flex flex-row align-items-start justify-content-start">
									<div>
										<div>
											<div class="product_name"><a href="">Aceite Primor</a></div>
											<div class="product_category"><a href="">Categoria</a></div>
										</div>
									</div>
									<div class="ml-auto text-right">
										<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
										<div class="product_price text-right">s/7<span>.99</span></div>
									</div>
								</div>
								<div class="product_buttons">
									<div class="text-right d-flex flex-row align-items-start justify-content-start">
										<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
										<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/cart.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Product -->
					<div class="col-xl-4 col-md-6">
						<div class="product">
							<div class="product_image"><img src="resources/images/catalogo2.jpg" alt=""></div>
							<div class="product_content">
								<div class="product_info d-flex flex-row align-items-start justify-content-start">
									<div>
										<div>
											<div class="product_name"><a href="">Arroz Costeño</a></div>
											<div class="product_category"><a href="">Categoria</a></div>
										</div>
									</div>
									<div class="ml-auto text-right">
										<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
										<div class="product_price text-right">s/15<span>.99</span></div>
									</div>
								</div>
								<div class="product_buttons">
									<div class="text-right d-flex flex-row align-items-start justify-content-start">
										<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
										<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/cart.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Product -->
					<div class="col-xl-4 col-md-6">
						<div class="product">
							<div class="product_image"><img src="resources/images/catalogo3.jpg" alt=""></div>
							<div class="product_content">
								<div class="product_info d-flex flex-row align-items-start justify-content-start">
									<div>
										<div>
											<div class="product_name"><a href="">Fideo Canuto</a></div>
											<div class="product_category"><a href="">Categoria</a></div>
										</div>
									</div>
									<div class="ml-auto text-right">
										<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
										<div class="product_price text-right">s/1<span>.20</span></div>
									</div>
								</div>
								<div class="product_buttons">
									<div class="text-right d-flex flex-row align-items-start justify-content-start">
										<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
										<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/cart.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Product -->
					<div class="col-xl-4 col-md-6">
						<div class="product">
							<div class="product_image"><img src="resources/images/catalogo4.jpg" alt=""></div>
							<div class="product_content">
								<div class="product_info d-flex flex-row align-items-start justify-content-start">
									<div>
										<div>
											<div class="product_name"><a href="">Azucar Dulfina</a></div>
											<div class="product_category"><a href="">Categoria</a></div>
										</div>
									</div>
									<div class="ml-auto text-right">
										<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
										<div class="product_price text-right">s/5<span>.99</span></div>
									</div>
								</div>
								<div class="product_buttons">
									<div class="text-right d-flex flex-row align-items-start justify-content-start">
										<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
										<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/cart.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Product -->
					<div class="col-xl-4 col-md-6">
						<div class="product">
							<div class="product_image"><img src="resources/images/catalogo5.jpg" alt=""></div>
							<div class="product_content">
								<div class="product_info d-flex flex-row align-items-start justify-content-start">
									<div>
										<div>
											<div class="product_name"><a href="">Leche Gloria</a></div>
											<div class="product_category"><a href="">Categoria</a></div>
										</div>
									</div>
									<div class="ml-auto text-right">
										<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
										<div class="product_price text-right">s/22<span>.99</span></div>
									</div>
								</div>
								<div class="product_buttons">
									<div class="text-right d-flex flex-row align-items-start justify-content-start">
										<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
										<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/cart.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Product -->
					<div class="col-xl-4 col-md-6">
						<div class="product">
                                                    <div class="product_image"><img src="resources/images/catalogo6.jpg" alt=""></div><br><br>
							<div class="product_content">
								<div class="product_info d-flex flex-row align-items-start justify-content-start">
									<div>
										<div>
											<div class="product_name"><a href="">Filete de Atún</a></div>
											<div class="product_category"><a href="">Categoria</a></div>
										</div>
									</div>
									<div class="ml-auto text-right">
										<div class="rating_r rating_r_4 home_item_rating"><i></i><i></i><i></i><i></i><i></i></div>
										<div class="product_price text-right">s/5<span>.99</span></div>
									</div>
								</div>
								<div class="product_buttons">
									<div class="text-right d-flex flex-row align-items-start justify-content-start">
										<div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
										<div class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
											<div><div><img src="resources/images/cart.svg" class="svg" alt=""><div>+</div></div></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="row load_more_row">
					<div class="col">
						<div class="button load_more ml-auto mr-auto"><a href="#">Cargar Mas</a></div>
					</div>
				</div>
			</div>
		</div>

		<!-- Boxes -->

		<div class="boxes">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="boxes_container d-flex flex-row align-items-start justify-content-between flex-wrap">

							<!-- Box -->
							<div class="box">
								<div class="background_image" style="background-image:url(resources/images/categoria1.jpg)"></div>
								<div class="box_content d-flex flex-row align-items-center justify-content-start">
									<div class="box_left">
										<div class="box_image">
											<a href="">
												<div class="background_image" style="background-image:url(resources/images/categoria1_img.jpg)"></div>
											</a>
										</div>
									</div>
									<div class="box_right text-center">
										<div class="box_title">Cereales</div>
									</div>
								</div>
							</div>

							<!-- Box -->
							<div class="box">
								<div class="background_image" style="background-image:url(resources/images/categoria2.jpg)"></div>
								<div class="box_content d-flex flex-row align-items-center justify-content-start">
									<div class="box_left">
										<div class="box_image">
											<a href="">
												<div class="background_image" style="background-image:url(resources/images/categoria2_img.jpg)"></div>
											</a>
										</div>
									</div>
									<div class="box_right text-center">
										<div class="box_title">Vinos y Licores</div>
									</div>
								</div>
							</div>

							<!-- Box -->
							<div class="box">
								<div class="background_image" style="background-image:url(resources/images/categoria3.jpg)"></div>
								<div class="box_content d-flex flex-row align-items-center justify-content-start">
									<div class="box_left">
										<div class="box_image">
											<a href="">
												<div class="background_image" style="background-image:url(resources/images/categoria3_img.jpg)"></div>
											</a>
										</div>
									</div>
									<div class="box_right text-center">
										<div class="box_title">Cereales</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Features -->

		<div class="features">
			<div class="container">
				<div class="row">
					
					<!-- Feature -->
					<div class="col-lg-4 feature_col">
						<div class="feature d-flex flex-row align-items-start justify-content-start">
							<div class="feature_left">
								<div class="feature_icon"><img src="resources/images/icon_1.svg" alt=""></div>
							</div>
							<div class="feature_right d-flex flex-column align-items-start justify-content-center">
								<div class="feature_title">Pagos Rápidos y Seguros</div>
							</div>
						</div>
					</div>

					<!-- Feature -->
					<div class="col-lg-4 feature_col">
						<div class="feature d-flex flex-row align-items-start justify-content-start">
							<div class="feature_left">
								<div class="feature_icon ml-auto mr-auto"><img src="resources/images/icon_2.svg" alt=""></div>
							</div>
							<div class="feature_right d-flex flex-column align-items-start justify-content-center">
								<div class="feature_title">Productos</div>
							</div>
						</div>
					</div>

					<!-- Feature -->
					<div class="col-lg-4 feature_col">
						<div class="feature d-flex flex-row align-items-start justify-content-start">
							<div class="feature_left">
								<div class="feature_icon"><img src="resources/images/icon_3.svg" alt=""></div>
							</div>
							<div class="feature_right d-flex flex-column align-items-start justify-content-center">
								<div class="feature_title">Entrega Gratis</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

		
			
	</div>
        </div>
        <script src="resources/js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="resources/css/popper.js" type="text/javascript"></script>
        <script src="resources/plugins/greensock/TweenMax.min.js" type="text/javascript"></script>
        <script src="resources/plugins/greensock/TimelineMax.min.js" type="text/javascript"></script>
        <script src="resources/plugins/scrollmagic/ScrollMagic.min.js" type="text/javascript"></script>
        <script src="resources/plugins/greensock/animation.gsap.min.js" type="text/javascript"></script>
        <script src="resources/plugins/greensock/ScrollToPlugin.min.js" type="text/javascript"></script>
        <script src="resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
        <script src="resources/plugins/easing/easing.js"></script>
        <script src="resources/plugins/progressbar/progressbar.min.js"></script>
        <script src="resources/plugins/parallax-js-master/parallax.min.js"></script>
        <script src="resources/js/custom.js"></script>
        
        
        
            
    </body>
    
</html>
