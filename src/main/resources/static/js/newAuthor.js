
$(document).ready(function () {
    $('.btnSave').on('click',function (event) {

        // the following section will validate that required fields are not empty and will highlight them in red
        // start of validation check section
        var form = document.getElementById('newAuthorForm');
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        }
        form.classList.add('was-validated');
        // end of validation check section








    });
})