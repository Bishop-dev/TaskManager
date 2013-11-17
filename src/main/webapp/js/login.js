$(function () {
    $('#loginForm').validate({
        rules: {
            login: {
                required: true
            }, password: {
                required: true
            }
        }, highlight: function (element) {
            $(element).closest('.control-group').removeClass('success').addClass('error');
        },
        success: function (element) {
            element.closest('.control-group').removeClass('error').addClass('success');
        }
    });
}());