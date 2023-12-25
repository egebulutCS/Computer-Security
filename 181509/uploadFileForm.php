<?php
	echo "<form enctype='multipart/form-data' action='uploadFile.php' method='POST'>";
	echo "Please choose a file to Upload:";
	echo "<br /><input name='chosenFile' type='file' />";
	echo "<br /><input type='submit' value='Upload File'>";
	echo "</form>";
?>