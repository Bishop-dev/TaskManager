$(function () {
    $.extend($.validator.messages, {
        required: "This field is required"
    });

    $('#loginForm').validate({
        rules: {
            j_username: {
                required: true
            },
            j_password: {
                required: true
            }
        }, highlight: function (element) {
            $(element).closest('.control-group').removeClass('success').addClass('error');
        },
        success: function (element) {
            element.closest('.control-group').removeClass('error').addClass('success');
        }
    });

    $('#loginForm').on('submit', function (event) {
        if (!$('#loginForm').valid()) {
            event.preventDefault();
        }
    });
});