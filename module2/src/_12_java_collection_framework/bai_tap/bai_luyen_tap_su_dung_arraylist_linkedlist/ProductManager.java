package _12_java_collection_framework.bai_tap.bai_luyen_tap_su_dung_arraylist_linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
    private final List<Product> productList = new ArrayList<>();

    // 1. Thêm sản phẩm
    public void add(Product pr) {
        productList.add(pr);
    }

    // Kiểm tra sản phẩm có tồn tại trong list không
    public boolean checkIsNotEmpty(Product pr) {
        return productList.contains(pr);
    }

    // 2. Sửa thông tin sản phẩm theo id
    public void update(Product pr) {
        productList.set(productList.indexOf(pr), pr);
    }

    // 3. Xóa sản phẩm theo id
    public void delete(int id) {
        productList.removeIf(e -> e.getId() == id);
    }

    // 4. Hiển thị danh sách sản phẩm
    public List<Product> display() {
        return productList;
    }

    // 5. Tìm kiếm sản phẩm theo tên
    public List<Product> find(String name) {
        return productList.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
    }

    // 6. Sắp xếp sản phẩm tăng dần/ giảm dần theo giá
    public void sort(boolean isASC){
        productList.sort((o1, o2) -> isASC ? (int) (o1.getPrice() - o2.getPrice()) : (int) (o2.getPrice() - o1.getPrice()));
    }
}
