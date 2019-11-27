<?php
	$template_stud = "
		<div class='pc_info'>
			<img src='pc_icon.png' class='sidebyside'/>
			<div class='box sidebyside'>
				<div class='admin'></div>
				<div class='info'>
					<h3>Computer Stud</h3>
					<p>Lokaal: A202</p>
					<p>Opleiding: EI</p>
				</div>
				<div class='btns'>
					<form action='details.php' method='POST'>
						<input class='light btn' type='submit' value='Reserveer' />
						<input class='light btn' type='submit' value='Details' />
					</form>
				</div>
			</div>
		</div>
	";
	
	$template_doc = "
		<div class='pc_info'>
			<img src='pc_icon.png' class='sidebyside'/>
			<div class='box sidebyside'>
				<div class='admin'>
					<a href=''><img src='close.svg' /></a>
					<a href=''><img src='pencil.svg' /></a>
				</div>
				<div class='info'>
					<h3>Computer Doc</h3>
					<p>Lokaal: A202</p>
					<p>Opleiding: EI</p>
				</div>
				<div class='btns'>
					<form action='details.php' method='POST'>
						<input class='light btn' type='submit' value='Details' />
					</form>
				</div>
			</div>
		</div>
	";
	
	$template_ext = "
		<div class='pc_info'>
			<img src='pc_icon.png' class='sidebyside' />
			<div class='box sidebyside'>
				<div class='admin'></div>
				<div class='info'>
					<h3>Computer Ext</h3>
					<p>Lokaal: A202</p>
					<p>Opleiding: EI</p>
				</div>
				<div class='btns'>
					<form action='details.php' method='POST'>
						<input class='light btn' type='submit' value='Reserveer' />
					</form>
				</div>
			</div>
		</div>
	";
	?>

<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="style.css">
		<title>Overzicht</title>
		
		<!--FONTS-->
		<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<?php 
			for($i=0;$i<7;$i++) {
				if($i % 3 == 1)
					echo $template_doc;
				elseif($i % 3 == 2)
					echo $template_ext;
				else
					echo $template_stud;
			}?>
		</div>
		<div class='btns_bottom'>
			<form action='' method='POST'>
				<input class='dark btn' type='submit' value='Toevoegen' />
			</form>
		</div>
	</body>
</html>