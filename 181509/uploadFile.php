<?php
	$filepath = "uploadedFiles/";
	$filepath = $filepath . basename($_FILES['chosenFile']['name']);
	$docFileType = strtolower(pathinfo($filepath,PATHINFO_EXTENSION));
	
	$uploadOk = 1;
	
	if (file_exists($filepath)){
		echo "Sorry, file already exists.";
		$uploadOk = 0;
	}
	
	if ($docFileType != "docx" && $docFileType != "pdf" && $docFileType != "doc"){
		echo "Sorry, only docx, doc & pdf files are allowed.";
		$uploadOk = 0;
	}
	
	if ($uploadOk == 0){
		echo "Sorry, your file was not uploaded.";
	} else {
		if (move_uploaded_file($_FILES['chosenFile']['tmp_name'], $filepath)){
			echo "The file named " . basename($_FILES['chosenFile']['name']) . " has been uploaded correctly!";
		} else {
			echo "The file named " . basename($_FILES['chosenFile']['name']) . " did not upload due to an error!";
		}
	}
	echo "<br><a href='index.php' class='btn btn-warning'>Home Page</a>";
?>