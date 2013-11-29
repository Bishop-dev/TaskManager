$(function () {
    $.extend($.validator.messages, {
        required: "This field is required",
        remote: "This login busy"
    });

    $('#loginForm').validate({
        rules: {
            login: {
                required: true,
                minlength: 5,
                maxlength: 20,
                remote: {
                    url: 'checkLogin',
                    type: 'get',
                    data: {
                        login: function () {
                            return $('#login').val();
                        }
                    }
                }
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 20
            },
            confirm: {
                required: true,
                equalsTo: '#password'
            },
            email: {
                required: true,
                email: true
            },
            phone: {
                required: true,
                digits: true,
                minlength: 10,
                maxlength: 10
            },
            firstName: {
                required: true
            },
            lastName: {
                required: true
            },
            birthday: {
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