package com.huangyunchi.service;

/**
 * 集中创建 service
 */
public class ServiceFactory {

    private static final AddressService addressService = new AddressService();

    private static final CategoryService categoryService = new CategoryService();

    private static final MemberService memberService = new MemberService();

    private static final NewsService newsService = new NewsService();

    private static final OrdersService ordersService = new OrdersService();

    private static final ProductService productService = new ProductService();

    public static AddressService getAddressService() {
        return addressService;
    }

    public static CategoryService getCategoryService() {
        return categoryService;
    }

    public static MemberService getMemberService() {
        return memberService;
    }

    public static NewsService getNewsService() {
        return newsService;
    }

    public static OrdersService getOrdersService() {
        return ordersService;
    }

    public static ProductService getProductService() {
        return productService;
    }
}
