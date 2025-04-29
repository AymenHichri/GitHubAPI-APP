@RestController
@RequestMapping("/repos")
public class RepositoryController {

    private final RepositoryService repositoryService;

    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/list")
    public List<RepositoryResponse> listRepositories(@RequestHeader("Authorization") String token) {
        return repositoryService.listRepositories(token);
    }

    @PostMapping("/move")
    public void moveRepository(@RequestHeader("Authorization") String token,
                                @RequestBody MoveRepositoryRequest request) {
        repositoryService.moveRepository(token, request);
    }
