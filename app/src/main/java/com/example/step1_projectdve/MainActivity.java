package com.example.step1_projectdve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.step1_projectdve.Data.DatabaseHandler;
import com.example.step1_projectdve.Modal.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);


//        databaseHandler.addProduct(new Product("Grip Clean","https://www.gripclean.com/"));
//        databaseHandler.addProduct(new Product("Prx Performance","https://prxperformance.com/"));
//        databaseHandler.addProduct(new Product("Slyde Hand Boards","https://www.slydehandboards.com/"));
//          databaseHandler.addProduct(new Product("Yahoo","https://www.yahoo.com/"));
//        Product product= new Product();
//        product.setName("Google");
//        product.setLink("https://www.google.com/");
//        databaseHandler.addProduct(product);
//        databaseHandler.addProduct(new Product("name","link"));

        //get Single Product

        Product singleProduct = databaseHandler.getSingleProduct(7);

        Log.d(TAG, "onCreate: SINGLE PRODUCT:: "+singleProduct.getName());

        //update id 10

        Product product10 = databaseHandler.getSingleProduct(10);
        product10.setName("New Update");
        product10.setLink("https://github.com/amansharma-dev");

        Log.d(TAG, "onCreate: UPDATED PRODUCT:: "+product10.getName());



        List<Product> productList = databaseHandler.getAllProduct();
        for(Product product : productList){
            Log.d(TAG, "onCreate: "+"NAME:-> "+product.getName()+"  LINK:-> "+product.getLink());
        }

        //get count

        Log.d(TAG, "onCreate: Count: "+databaseHandler.getCount());
    }
}
