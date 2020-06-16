/*使用jQuery处理分类菜单的显示和隐藏*/
var cate = $("#categories");
if (cate[0]) {
    $(".categories").hover(function () {
        $("#menu").show();
    }, function () {
        $("#menu").hide();
    });
}

/*使用jQuery来处理子分类菜单的显示和隐藏*/
$("#menu > .cate-list > li").hover(function () {
    $(".sub-list", $(this)).show();
}, function () {
    $(".sub-list", $(this)).hide();
});


/*QQ客服鼠标悬停事件*/
$(".slidebar-qq").hover(function () {
    $(".qq", $(this)).show();
}, function () {
    $(".qq", $(this)).hide();
});

/*客服电话鼠标悬停事件*/
$(".slidebar-phone").hover(function () {
    $(".phone", $(this)).show();
}, function () {
    $(".phone", $(this)).hide();
});

/*公众号鼠标悬停事件*/
$(".slidebar-wx").hover(function () {
    $(".pic", $(this)).show();
}, function () {
    $(".pic", $(this)).hide();
});


/*给页面添加滚动到顶部的jQuery插件*/
$.scrollUp({scrollText: ''});


/*计数组件 */
$('.icon-plus').parent().click(function () {//给 +号的父亲元素添加点击事件
    var countInput = $(this).prev('input'); //获取input元素
    var num = parseInt(countInput.val()) + 1; //获取input中的值并转化成整数再加上1
    countInput.val(num); //把值赋给input
    countInput.change(); //触发change事件
});

$('.icon-minus').parent().click(function () { //给-号的父亲元素添加点击事件
    var countInput = $(this).next('input');
    if (countInput.val() <= 1) {
        return false;
    }

    countInput.val(parseInt(countInput.val()) - 1);
    countInput.change(); //触发change事件
});

$('input[name=amount]').change(function () { //数量输入框的值改变事件处理函数--->计算本行的总金额

    var amount = parseInt($(this).val()); //获取当前的数量并转化为整数
    var price = parseFloat($(this).parents('tr').find('#price').text());//获取当前表格行中的商品价格并转化为浮点数
    var sum = (amount * price).toFixed(2); //计算当前表格行的值，取两位小数
    $(this).parents('tr').find('#sum').text(sum);
    countSum(); //计算总价格
});

/*计算总数量及总价格*/
function countSum() {
    var amount = 0;
    var price = 0;
    $('#cart-list>tr').each(function () { //循环表格的每一行
        amount += parseInt($("#amount", $(this)).val());
        price = (parseFloat(price) + parseFloat($("#sum", $(this)).text())).toFixed(2);
    })
    $('#amount-sum').text(amount);
    $('#price-sum').text(price);
}

const validator = (() => {
    return {
        /* 合法uri */
        validateURL(textval) {
            const urlregex = /^(?:http(s)?:\/\/)?[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?#[\]@!\$&'\*\+,;=.]+$/
            return urlregex.test(textval)
        }
        /* 小写字母 */
        , validateLowerCase(str) {
            const reg = /^[a-z]+$/
            return reg.test(str)
        }
        /* 大写字母 */
        , validateUpperCase(str) {
            const reg = /^[A-Z]+$/
            return reg.test(str)
        }
        /* 大小写字母 */
        , validateAlphabets(str) {
            const reg = /^[A-Za-z]+$/
            return reg.test(str)
        }
        /* 市场售价 */
        , validatePrice(str) {
            const reg = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/
            return reg.test(str)
        }
        /* 库存预警值 匹配非负整数（正整数 + 0） */
        , validatestockWarn(str) {
            const reg = /^(0|[1-9][0-9]*)$/
            return reg.test(str)
        }
        /* 比价网站 只验证京东和苏宁网站 */
        , validateCompareWebsite(str) {
            const reg = /^((https\:\/\/[0-9a-zA-Z\_]+\.|http\:\/\/[0-9a-zA-Z\_]+\.|https\:\/\/|http\:\/\/)|([0-9a-zA-Z\_]+\.){0,1})(jd|suning)\.(com$|com\/[\S]*)/i
            return reg.test(str)
        }
        /* 固定电话 */
        , telephone(str) {
            const reg = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/
            return reg.test(str)
        }
        /* 手机号码 */
        , phoneNumber(str) {
            const reg = /^[1][3456789][0-9]{9}$/
            return reg.test(str)
        }
        /* 手机号码和固定电话 */
        , validatePhTelNumber(str) {
            const reg = /^((0\d{2,3}-\d{7,8})|(1[3456789]\d{9}))$/
            return reg.test(str)
        }
        /* 电子邮箱 */
        , validateEmail(str) {
            const reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
            return reg.test(str)
        }
        /* 邮编 */
        , validateZipCode(str) {
            const reg = /^[1-9][0-9]{5}$/
            return reg.test(str)
        }
        /* 身份证 */
        , validateIDCard(str) {
            const reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
            return reg.test(str)
        }
        /* 银行卡号 15位或者16位或者19位 */
        , validateBank(str) {
            const reg = /^([1-9]{1})(\d{14}|\d{18}|\d{15})$/
            return reg.test(str)
        }
        /* 纳税人识别码 */
        , validateTaxpayer(str) {
            const reg = /^([1-9]{1})(\d{14}|\d{18}|\d{15})$/
            return reg.test(str)
        }
        /* 匹配全空格 */
        , validateAllBlank(str) {
            const reg = /^\s+$/gi
            return reg.test(str)
        },
        username(str){
            const re = /^[a-zA-z]\w{3,15}$/;
            return re.test(str);
        },
        password(str) {
            return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*?[#?!@$%^&*-]).{6,}$/.test(str);
        }
    }
})();
