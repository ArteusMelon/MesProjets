<?php
define('ROOT', str_replace('index.php', '', $_SERVER['SCRIPT_FILENAME']));
$params = explode('/', $_GET['p']);
var_dump(ROOT);



if($params[0]!= ""){

$controller = ucfirst($params[0]);
$action = isset($params[1])?$params[1]:'index';
require_once(ROOT.'controllers/'.$controller.'.php');
$controller= new $controller();
if(method_exists($controller, $action)){
    $controller->$action();
}else{
    http_response_code(404);
    echo "La page demandée n'existe pas";
}

}else{
    
}
?>