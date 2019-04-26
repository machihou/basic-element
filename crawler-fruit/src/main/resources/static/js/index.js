$(document).ready(function () {
    new Vue({
        el: '#app',
        data: function () {
            return {
                modal1: false,
                menuData: null
            };
        },
        methods: {
            select(hello) {
                console.log(hello)
                window.location.hash = hello;
            },
            initMenu() {
                let _this = this;
                $.get("/sys/menu/currentMenu",{}, function (data) {

                        _this.menuData = data.result.children;
                });
            }
        }, mounted() {
            // this.initMenu();
        }

    });

    window.onhashchange = function () {
        var href = window.location.hash;
        var $singlePage = $("#single-page-con")
        if (!href) {
            return;
        }
        href = decodeURIComponent(href);
        var index = href.lastIndexOf("#");
        var target = href.substr(index + 1);
        // console.log(target)
        $.get(target, {}, function (data) {
            $singlePage.html(data);
        })
    };

    if (window.location.hash === "") {
        let $singlePage = $("#single-page-con")
        $.get("/Home.html", {}, function (data) {
            $singlePage.html(data);
        });
        return;

    }
    if (window.location.hash !== '#') {

        let $singlePage = $("#single-page-con")
        var href = window.location.hash;
        // console.log(href)
        let index = href.lastIndexOf("#");
        let target = href.substr(index + 1);
        $.get(target, {}, function (data) {
            $singlePage.html(data);
        })
    }
});
