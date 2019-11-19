document.addEventListener("DOMContentLoaded", function() {
// create an arrayList of text fields
var array = document.getElementsByClassName("toUppercase");
// iterate through the array list and capitalize the first letter of each word using function
for(var i = 0; i < array.length; i++) {
    array[i].innerText = changeCaseFirstLetter(array[i].innerText);
    }
});



function changeCaseFirstLetter(params) {
        if(typeof params === 'string') {
                return params.charAt(0).toUpperCase() + params.slice(1);
        }
        return null;
}