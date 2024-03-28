<?php
session_start();
$people = $_SESSION["people"];
echo "<table border=1 >";
echo "<tr>";
echo "<td>Famille</td>";
foreach ($people as $key => $value) {
    echo "<th>" . $key . "</th>";
    
}
echo "</tr>";

echo "<tr>";
echo "<th> Father </th>";
foreach ($people as $key => $value) {
    echo "<td>" . $value["Father"] . "</td>";
    
}
echo "</tr>";

echo "<tr>";
echo "<th> Mother </th>";
foreach ($people as $key => $value) {
    echo "<td>" . $value["Mother"] . "</td>";
    
}
echo "</tr>";

echo "<tr>";
echo "<th> Child </th>";
foreach ($people as $key => $value) {
    echo "<td>" . $value["Child"] . "</td>";
    
}
echo "</tr>";



echo "</table>";
?>