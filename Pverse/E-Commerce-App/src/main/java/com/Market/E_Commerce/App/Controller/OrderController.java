package com.Market.E_Commerce.App.Controller;

import com.Market.E_Commerce.App.RequestDTO.OrderRequestDto;
import com.Market.E_Commerce.App.ResponseDTO.OrderResponseDto;
import com.Market.E_Commerce.App.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

      @Autowired
      OrderService orderService;

      @PostMapping("/place")
      public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto){

            OrderResponseDto orderResponseDto;

            try{
                  orderResponseDto = orderService.placeOrder(orderRequestDto);
            }
            catch(Exception e){
                  return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity(orderResponseDto,HttpStatus.ACCEPTED);
      }

}
