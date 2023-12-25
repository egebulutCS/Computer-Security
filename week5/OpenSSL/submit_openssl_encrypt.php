<?php

namespace OpenSSLTest;

include './openssl_config.php';
$config = new openssl_config();
$secretHash = $config->getSecretHash();
$encryptionMethod = $config->getEncryptionMethod();

$textToEncrypt = $_POST['message'];

$bytes = "";
$last = "";

while(strlen($bytes) < 48) {
    $last = md5($last . $secretHash, true);
    $bytes.= $last;
}

$iv = substr($bytes, 32, 16);
$encryptedMessage = openssl_encrypt($textToEncrypt, $encryptionMethod, $secretHash, 0, $iv);

echo '<html><head></head><body>
Encrypted Message <textarea cols="50" rows="3">'.base64_encode($encryptedMessage).'</textarea>
</body></html>';
