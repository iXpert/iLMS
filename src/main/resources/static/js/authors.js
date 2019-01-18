
$(document).ready(function() {


    var theTable = $('#tblAuthors').dataTable({bFilter: false, bInfo: false, bLengthChange: false, pageLength: 12}); // this is to trigger the jquery datatable features of the authors page


    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#tblAuthors tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });


    $("#tblAuthors tr .btnEditAuthor").on('click',function (event) {
        var $row = $(this).closest("tr");
        var $currentId = $row.find("td:nth-child(1)").text();
        var $currentFName = $row.find("td:nth-child(2)").text();
        var $currentLName = $row.find("td:nth-child(3)").text();
        var $currentNationality = $row.find("td:nth-child(4)").text();

        $('#authorDataModal #firstName').val($currentFName);
        $('#authorDataModal #lastName').val($currentLName);
        $('#authorDataModal #nationality').val($currentNationality);

        $('#authorDataModal').modal("show");
    });



});


