//    function Add() {
//       var ddl = document.getElementById("clothesTypeDropDown");
//       var option = document.createElement("OPTION");
//       option.innerHTML = document.getElementById("txtText").value;
//       option.value = document.getElementById("txtValue").value;
//       ddl.options.add(option);
//   }

// get reference to select element
//var sel = document.getElementById('clothingTypeDropDown');
//
//// create new option element
//var opt = document.createElement('option');
//
//// create text node to add to option element (opt)
//opt.appendChild( document.createTextNode('New Option Text') );
//
//// set value property of opt
//opt.value = 'option value';
//
//// add opt to end of select box (sel)
//sel.appendChild(opt);


document.getElementById("addButton").addEventListener("click", function(event){
  event.preventDefault(),
  insertValue()
});


             function insertValue()
            {
            alert("insertValue running!")
                var select = document.getElementById("clothesTypeDropDown"),
                    txtVal = document.getElementById("val").value,
                    newOption = document.createElement("OPTION"),
                    newOptionVal = document.createTextNode(txtVal);

                newOption.appendChild(newOptionVal);
                select.insertBefore(newOption,select.firstChild);
            }