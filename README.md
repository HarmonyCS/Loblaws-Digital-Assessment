Loblaws Technical Assessment
===================================

Instructions
------------

We, at Loblaw Digital, are responsible for the client-facing components of e-commerce applications. This means that we build and maintain lists of products that users can purchase. 

Please create a small native application that has the following features:
1. A network component that retrieves JSON from the [Endpoint](https://gist.githubusercontent.com/r2vq/2ac197145db3f6cdf1a353feb744cf8e/raw/b1e722f608b00ddde138a0eef2261c6ffc8b08d7/cart.json). The documentation for this endpoint is on [Swagger](https://app.swaggerhub.com/apis-docs/Products-Sample/Products/1.0.0#/Product).
2. A screen that shows a list of the retrieved products, their name, and their thumbnails.
3. A second screen that opens when the user clicks on any of the products on the previous screen. This second screen should show the product details of the product from the first screen.

Although the app should be simple, it should run on a simulator/emulator/physical device. We should be able to build your project on the latest released version of XCode or AndroidStudio. 
You can reuse patterns that follow industry standards but please do not copy and paste code. We will not be linting your code, but please submit clean, readable code as if you are submitting
it to a production project. 

Finally, your code should be written in such a way that we can scale it and grow it to an enterprise-level production application.

Push your code to a public GitHub repository and please send us the link within 72 hours. If more time is required, please let us know.

Introduction
------------

This simple app shows a list of products that are available for purchase. The product data is pulled from a REST web service.
This app demonstrates the use of [Retrofit](https://square.github.io/retrofit/) to make REST requests to the 
web service, [Moshi](https://github.com/square/moshi) to handle the deserialization of the 
returned JSON to Kotlin data objects, and [Glide](https://bumptech.github.io/glide/) to load and 
cache images by URL.  

The app also leverages [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel),
[LiveData](https://developer.android.com/topic/libraries/architecture/livedata), 
[Data Binding](https://developer.android.com/topic/libraries/data-binding/) with binding 
adapters, and [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) 
with the SafeArgs plugin for parameter passing between fragments.

Future Improvements
-------------------

- Image Loading 
    - Error Handling 
    - Slow Loading
- Data binding for Product List Recycler View
- Sort Products into categories
- Testing
