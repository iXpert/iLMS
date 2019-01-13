
$(document).ready(function() {


    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#tblAuthors tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });



   // function koko(){
   //     alert("kjkhkjhk");
   // }



    $("#btnNewAuthor").on('click',function (event) {

        alert("Hello");

       // clear the modal form
       $('#authorDataForm #firstName').val('');
       $('#authorDataForm #lastName').val('');
       $('#authorDataForm #nationality').val('Choose...');

       // display modal form
        $('#authorDataForm').modal();

    });





});


