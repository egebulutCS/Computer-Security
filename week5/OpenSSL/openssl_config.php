<?php
namespace OpenSSLTest;

class openssl_config{
    
    private $encryptionMethod;
    private $secretHash = "";
    
    public function __construct(){
        $this->encryptionMethod = 'AES-256-CBC';
        $this->secretHash = 'h476dxAFGHG#dgh47y4hjkdgloPRtud@66guh94gdfFGx0&1dgd';
    }
    
    
    public function getEncryptionMethod(){
        return $this->encryptionMethod;
    }
    
    public function getSecretHash(){
        return $this->secretHash;
    }
}
