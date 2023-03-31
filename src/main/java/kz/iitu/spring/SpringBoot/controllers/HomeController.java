package kz.iitu.spring.SpringBoot.controllers;


import kz.iitu.spring.SpringBoot.beans.FirstBean;
import kz.iitu.spring.SpringBoot.beans.SecondBean;
import kz.iitu.spring.SpringBoot.db.DBManager;
import kz.iitu.spring.SpringBoot.db.Items;
import kz.iitu.spring.SpringBoot.entities.Posts;
import kz.iitu.spring.SpringBoot.entities.ShopItems;
import kz.iitu.spring.SpringBoot.repositories.PostRepository;
import kz.iitu.spring.SpringBoot.services.ItemService;
import kz.iitu.spring.SpringBoot.services.PostService;
import kz.iitu.spring.SpringBoot.services.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FirstBean firstBean;
    @Autowired
    private SecondBean secondBean;
    @Autowired
    private SecondBean theSecondBean;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ShopItemService shopItemService;
    @Autowired
    private PostService postService;

    @GetMapping(value = "/") //WebServlet(value ="/")
    public String indexPage(Model model) {

        List<Posts> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        List<ShopItems> items = shopItemService.getAllItems();
        model.addAttribute("tovary", items); //request.setAttribute("tovary", items);
        return "index"; //request.GetRequestDispatcher("/index.html").forward(request, response);
    }

    @GetMapping(value = "about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping(value = "login")
    public String loginPage() {
        firstBean.setName("Alikhan");
        return "login";
    }

    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name="item_name", required = false, defaultValue = "No item Name") String name,
                          @RequestParam(name="item_price", defaultValue = "0") double price,
                          @RequestParam(name="item_amount") int amount){

        ShopItems item = new ShopItems();
        item.setName(name);
        item.setPrice(price);
        item.setAmount(amount);

        shopItemService.addItem(item);

        return "redirect:/";//response.sendRedirect("/");
    }

    @GetMapping(value = "/details/{itemId}")
    public String itemDetails(Model model, @PathVariable(name="id") Long id) {

        ShopItems item = shopItemService.getItem(id);

        model.addAttribute("tovar", item);

        return "details";
    }

    @GetMapping(value = "/setname/{userName}")
    public String setName(@PathVariable(name = "userName") String userName){
        firstBean.setName(userName);
        return "redirect:/";
    }
    @GetMapping(value = "/testindex")
    public String test(Model model){
        model.addAttribute("name",firstBean.getName() + " " + secondBean.getAge());

        return "test";
    }

    @GetMapping(value = "/posts")
    public String posts(Model model){
        List<Posts> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        return "posts";
    }

    @PostMapping(value = "/addpost")
    public String addPost(@RequestParam(name="title") String title,
                          @RequestParam(name="content") String content){

        Posts post = new Posts();
        post.setTitle(title);
        post.setContent(content);
        post.setPostDate(new Timestamp(System.currentTimeMillis()));

        postService.addPost(post);

        return "redirect:/posts";
    }

    @GetMapping(value = "/postdetails/{id}")
    public String postDetails(@PathVariable(name = "id") Long id, Model model){
        Posts post = postService.getPost(id);
        model.addAttribute("post", post);

        return "postdetails";
    }
    @PostMapping(value = "/savepost")
    public String savePost(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content){

        Posts post = postService.getPost(id);
        if(post!=null){
            post.setContent(content);
            post.setTitle(title);
            postService.savePost(post);

            return "redirect:/postdetails/"+id;
        }
        return  "redirect:/posts";
    }
    @PostMapping(value = "/deletepost")
    public String deletePost(@RequestParam(name = "id") Long id){
        System.out.println("Lol");
        Posts post = postService.getPost(id);
        if(post!=null){
            postService.deletePost(post);
            return "redirect:/posts";
        }
        return  "/";
    }
}
