/* Questao 2 */
var form2 = document.getElementById("quest2");
form2.addEventListener("submit", function(e){
    var num = e.srcElement[0].value;
        e.preventDefault();
    if(!(num==parseInt(num))){
        e.target.lastElementChild.innerText = "Valor invalido. Por favor digite um inteiro.";
        e.srcElement[0].value = "";
        e.srcElement[0].focus();
    }
    else 
        form2.submit();
});



