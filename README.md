Dưới đây là toàn bộ các bảng và mối quan hệ được thiết kế lại để phù hợp với hệ thống bán vé tàu xe chịu được tải lớn, bao gồm cả việc quản lý số ghế.

1. Bảng User (Người dùng)
Lưu trữ thông tin của tất cả người dùng (admin, customer).

Trường	Kiểu dữ liệu	Ghi chú
user_id	INT	PK, auto increment
username	VARCHAR(255)	Tên đăng nhập
password	VARCHAR(255)	Mật khẩu đã mã hóa
email	VARCHAR(255)	Email người dùng
phone	VARCHAR(20)	Số điện thoại
role	VARCHAR(50)	Vai trò (admin, customer)
created_at	TIMESTAMP	Ngày tạo tài khoản
updated_at	TIMESTAMP	Ngày cập nhật tài khoản
google_id	VARCHAR(255)	ID Google (dùng để đăng nhập bằng Google)
2. Bảng Vehicle (Xe/Tàu)
Lưu trữ thông tin xe hoặc tàu.

Trường	Kiểu dữ liệu	Ghi chú
vehicle_id	INT	PK, auto increment
vehicle_name	VARCHAR(255)	Tên xe hoặc tàu
vehicle_type	VARCHAR(50)	Loại phương tiện (xe bus, giường nằm, tàu)
total_seats	INT	Tổng số ghế
created_at	TIMESTAMP	Ngày tạo
updated_at	TIMESTAMP	Ngày cập nhật
3. Bảng Route (Tuyến đường)
Lưu trữ thông tin tuyến đường (nơi đi, nơi đến, v.v.).

Trường	Kiểu dữ liệu	Ghi chú
route_id	INT	PK, auto increment
start_station	VARCHAR(255)	Điểm bắt đầu
end_station	VARCHAR(255)	Điểm kết thúc
distance	DECIMAL(10,2)	Quãng đường (km)
duration	TIME	Thời gian di chuyển
created_at	TIMESTAMP	Ngày tạo
updated_at	TIMESTAMP	Ngày cập nhật
4. Bảng Trip (Chuyến đi)
Lưu trữ thông tin chi tiết về chuyến đi (kết hợp giữa xe/tàu và tuyến đường).

Trường	Kiểu dữ liệu	Ghi chú
trip_id	INT	PK, auto increment
vehicle_id	INT	FK, liên kết với bảng Vehicle
route_id	INT	FK, liên kết với bảng Route
departure_time	TIMESTAMP	Thời gian khởi hành
arrival_time	TIMESTAMP	Thời gian đến
price	DECIMAL(10,2)	Giá vé cho chuyến đi
created_at	TIMESTAMP	Ngày tạo
updated_at	TIMESTAMP	Ngày cập nhật
5. Bảng Seat (Ghế)
Lưu trữ thông tin từng ghế của xe/tàu.

Trường	Kiểu dữ liệu	Ghi chú
seat_id	INT	PK, auto increment
seat_number	VARCHAR(10)	Số ghế (ví dụ: A1, A2, B1)
status	VARCHAR(50)	Trạng thái ghế (trống, đã đặt, đang đặt)
type	VARCHAR(50)	Loại ghế (thường, VIP, giường nằm)
price	DECIMAL(10,2)	Giá vé cho ghế (có thể thay đổi tùy loại)
vehicle_id	INT	FK, liên kết với bảng Vehicle
booking_id	INT	FK, liên kết với bảng Booking (nullable)
created_at	TIMESTAMP	Ngày tạo
updated_at	TIMESTAMP	Ngày cập nhật
6. Bảng Booking (Đặt vé)
Lưu trữ thông tin về đơn đặt vé của khách hàng.

Trường	Kiểu dữ liệu	Ghi chú
booking_id	INT	PK, auto increment
user_id	INT	FK, liên kết với bảng User
trip_id	INT	FK, liên kết với bảng Trip
seat_id	INT	FK, liên kết với bảng Seat
booking_date	TIMESTAMP	Ngày đặt vé
status	VARCHAR(50)	Trạng thái đặt vé (chờ thanh toán, đã thanh toán, hủy)
payment_method	VARCHAR(50)	Phương thức thanh toán (tiền mặt, thẻ, ví điện tử)
created_at	TIMESTAMP	Ngày tạo
updated_at	TIMESTAMP	Ngày cập nhật
7. Bảng Payment (Thanh toán)
Lưu trữ thông tin chi tiết về thanh toán.

Trường	Kiểu dữ liệu	Ghi chú
payment_id	INT	PK, auto increment
booking_id	INT	FK, liên kết với bảng Booking
amount	DECIMAL(10,2)	Số tiền thanh toán
payment_date	TIMESTAMP	Ngày thanh toán
status	VARCHAR(50)	Trạng thái thanh toán (đã thanh toán, thất bại)
created_at	TIMESTAMP	Ngày tạo
updated_at	TIMESTAMP	Ngày cập nhật
8. Bảng Discount (Giảm giá)
Lưu trữ thông tin về các mã giảm giá.

Trường	Kiểu dữ liệu	Ghi chú
discount_id	INT	PK, auto increment
code	VARCHAR(50)	Mã giảm giá
description	VARCHAR(255)	Mô tả chi tiết về giảm giá
discount_type	VARCHAR(50)	Loại giảm giá (% hoặc số tiền cụ thể)
discount_value	DECIMAL(10,2)	Giá trị giảm giá
start_date	TIMESTAMP	Ngày bắt đầu giảm giá
end_date	TIMESTAMP	Ngày kết thúc giảm giá
created_at	TIMESTAMP	Ngày tạo
updated_at	TIMESTAMP	Ngày cập nhật
9. Bảng Station (Ga/Trạm)
Lưu trữ thông tin về các ga hoặc trạm (nơi xuất phát, điểm dừng).

Trường	Kiểu dữ liệu	Ghi chú
station_id	INT	PK, auto increment
station_name	VARCHAR(255)	Tên ga/trạm
location	VARCHAR(255)	Địa chỉ cụ thể
created_at	TIMESTAMP	Ngày tạo
updated_at	TIMESTAMP	Ngày cập nhật
