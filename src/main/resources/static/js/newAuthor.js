
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


    // the following section will be triggered when the btnModalBack2Home button is clicked

        $('.btnModalBack2Home').on('click',function (event) {

            alert('Hi');

            //event.preventDefault(); // to prevent the default action of jquery when the button is clicked
            //var href = $(this).attr('href'); // this will return which button was clicked in dialog
            //$('#myModal #delRef').attr('href',href); // set the href of the button
            //$('#myModal').modal(); // display the modal dialogue
        });





    });
})