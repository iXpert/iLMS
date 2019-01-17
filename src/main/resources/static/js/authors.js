
$(document).ready(function() {

    $('#tblAuthors').dataTable({bFilter: false, bInfo: false, bLengthChange: false, pageLength: 15}); // this is to trigger the jquery datatable features of the authors page




    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#tblAuthors tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });




});


