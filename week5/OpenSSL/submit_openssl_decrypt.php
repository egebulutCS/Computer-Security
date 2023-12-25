<?php
namespace OpenSSLTest;

include './openssl_config.php';
$config = new openssl_config();
$secretHash = $config->getSecretHash();
$encryptionMethod = $config->getEncryptionMethod();

$cipherText = base64_decode($_POST['enString']);

$bytes = "";
$last = "";

while(strlen($bytes) < 48) {
    $last = md5($last . $secretHash, true);
    $bytes.= $last;
}

$iv = substr($bytes, 32, 16);
$decryptedMessage = openssl_decrypt($cipherText, $encryptionMethod, $secretHash, 0, $iv);

echo '<html><head></head><body>
Decrypted Message <textarea cols="50" rows="3">'.$decryptedMessage.'</textarea>
</body></html>';
