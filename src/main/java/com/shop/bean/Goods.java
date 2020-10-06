package com.shop.bean;

import java.math.BigDecimal;

public class Goods {

        private Integer id;
        private String name;
        private String producer;
        private BigDecimal price;
        private Integer sales;
        private Integer stock;
        private String img_path = "static/img/default.jpg";

        public Goods(Integer id, String name, String producer, BigDecimal price, Integer sales, Integer stock, String img_path) {
                this.id = id;
                this.name = name;
                this.producer = producer;
                this.price = price;
                this.sales = sales;
                this.stock = stock;
                this.img_path = img_path;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getProducer() {
                return producer;
        }

        public void setProducer(String producer) {
                this.producer = producer;
        }

        public BigDecimal getPrice() {
                return price;
        }

        public void setPrice(BigDecimal price) {
                this.price = price;
        }

        public Integer getSales() {
                return sales;
        }

        public void setSales(Integer sales) {
                this.sales = sales;
        }

        public Integer getStock() {
                return stock;
        }

        public void setStock(Integer stock) {
                this.stock = stock;
        }

        public String getImg_path() {
                return img_path;
        }

        public void setImg_path(String img_path) {
                this.img_path = img_path;
        }

        public Goods() {
        }

        @Override
        public String toString() {
                return "Goods{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", producer='" + producer + '\'' +
                        ", price=" + price +
                        ", sales=" + sales +
                        ", stock=" + stock +
                        ", img_path='" + img_path + '\'' +
                        '}';
        }
}
