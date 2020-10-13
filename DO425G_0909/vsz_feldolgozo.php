<html>
<body> 

<?php 
	if(isset($_GET['kuld'])){
	if(isset($_GET['nev'])  && !preg_match("/^[a-zA-Z-' ]*$/",$_GET['nev'])){
	echo " Név: ". $_GET['nev']."<br>\n" ;
	}
	else{
		print("A név nem megfelelő formátumú (Csak betű használható)"."<br>\n");
	}
	if(isset($_GET['pin']) && !empty($_GET['pin'])){
	echo " Pin kód: ". $_GET['pin']."<br>\n";
	}
	else{
		print("A pinkód nem lett megadva" ."<br>\n");
	}
	if(isset($_GET['gyumolcs']) && !empty($_GET['gyumolcs']) && !preg_match("/^[a-zA-Zöüóőúéáűäş&#537;ţ&#539;îâŞ&#536;Ţ&#538;ÎÂÖÜÓŐÚÉÁŰ]{2,30}$/",$_GET['nev'])){
	echo " Kedvenc gyümölcs: ". $_GET['gyumolcs']."<br>\n";
	}
	else{
		print("A gyümölcs nem megfelelő formátumú(Szám nem használható)" ."<br>\n");
	}
	if(isset($_GET['kor']) && !empty($_GET['kor']) && ("1"<$_GET['kor'] && "120">$_GET['kor'])){
	echo " Életkor: ". $_GET['kor']."<br>\n";
	}
	else{
		print("A kor nem megfelelő(1 és 120 közötti számot kérünk!)" ."<br>\n");
	}
	
	if(isset($_GET['meret']) && !empty($_GET['meret'])&& ("15"<$_GET['meret'] && "60">$_GET['meret'])){
	echo " Lábméret: ". $_GET['meret']."<br>\n";
	}
	else{
		print("A lábméret nem megfelelő(15 és 60 közötti számot kérünk)" ."<br>\n");
	}
	if(isset($_GET['range']) && !empty($_GET['range'])){
	echo " Önbizalom: ". $_GET['range']."<br>\n";
	}
	else{
		print("Az önzbizalom nem lett megadva"."<br>\n");
	}
	
	
	
	
	
	
	}
	
	if(isset($_GET['kuldd'])){
		
	echo " Név: ".$_GET['nev']."<br>\n" ;
	echo " Pin kód: ".$_GET['pin']."<br>\n";
	echo " Kedvenc gyümölcs: ".$_GET['gyumolcs']."<br>\n";
	echo " Életkor: ".$_GET['kor']."<br>\n";
	echo " Lábméret: ".$_GET['meret']."<br>\n";
	echo " Önbizalom: ".$_GET['range']."<br>\n";
		
		
	}
	
		
	
?> 

<form>

<button type="button" onclick="location.href='http://localhost/vsz_form.html';">Vissza</button>
</form>
</body>
</html>