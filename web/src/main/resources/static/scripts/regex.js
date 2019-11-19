document.getElementById("submitLogin").addEventListener("click", function(event){
var inputText = document.loginForm.submitLogin.value
event.preventDefault()
if(ValidateEmail(inputText) {
    alert("valid email")
    }
alert("jscript done!")
}

});


function ValidateEmail(inputText)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(inputText.value.match(mailformat))
{
document.form1.text1.focus();
return true;
}
else
{
alert("You have entered an invalid email address!");
document.form1.text1.focus();
return false;
}
}