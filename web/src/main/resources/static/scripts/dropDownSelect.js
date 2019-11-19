document.getElementById("addButton").addEventListener("click", function(event){
alert("button clicked!"),
  event.preventDefault(),
  insertValue()
});





             function insertValue()
            {
            alert("insertValue running!")
                var select = document.getElementById("clothesTypeDropdown");
                    txtVal = document.getElementById("val").value;
                    newOption = document.createElement("OPTION");
                    newOptionVal = document.createTextNode(txtVal);

                newOption.appendChild(newOptionVal);
                select.insertBefore(newOption,select.firstChild);
                document.getElementById("val").value = "";
            }
