$(document).ready(function () {

    $('#tblAuthors').dataTable({bFilter: false, bInfo: false, bLengthChange: false, pageLength: 12, fixedHeader: true}); // this is to trigger the jquery datatable features of the authors page

    // support search text box
    $("#authorSearch").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#tblAuthors tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });




    // show author edit dialog
    $('#tblAuthors').on('click','tr #btnEditAuthor',function () {
        var $row = $(this).closest("tr");
        var $currentId = $row.find("td:nth-child(1)").text();
        var $currentFName = $row.find("td:nth-child(2)").text();
        var $currentLName = $row.find("td:nth-child(3)").text();
        var $currentNationality = $row.find("td:nth-child(4)").text();
        $('#authorDataModal #id').val($currentId);
        $('#authorDataModal #firstName').val($currentFName);
        $('#authorDataModal #lastName').val($currentLName);
        $('#authorDataModal #nationality').val($currentNationality);

        $('#authorDataModal').modal("show");
    })

    // show confirm delete dialog
    $('#tblAuthors').on('click','tr #btnDeleteAuthor',function (event) {

        event.preventDefault();
        var $currentHref = $(this).attr('href');
        $('#authorDeleteModal #btnAuthorDeleteModal').attr('href',$currentHref);
        $('#authorDeleteModal').modal("show");
    })








})