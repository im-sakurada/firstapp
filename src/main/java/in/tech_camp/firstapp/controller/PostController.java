package in.tech_camp.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.tech_camp.firstapp.entity.PostEntity;
import in.tech_camp.firstapp.form.PostForm;
import in.tech_camp.firstapp.repository.PostRepository;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    
    @GetMapping("/hello")
    public String showHello(Model model){
        var sampleText = "サンプルテキスト";
   model.addAttribute("sampleText", sampleText);
        return "hello.html";
        }
    @GetMapping("/")
    public String showList(Model model) {
        var postList = postRepository.findAll();
        model.addAttribute("postList", postList);
        return "posts/index";
    }
    
    @GetMapping("/posts/new")
  public String showPostForm(@ModelAttribute("postForm") PostForm form){
    return "posts/postForm";
  }
  @PostMapping("/posts")
  public String savePost(@ModelAttribute("postForm")PostForm form){
    PostEntity post =new PostEntity();
    post.setContent(form.getContent());
    postRepository.insert(post);
    return "redirect:/";
  }
}
