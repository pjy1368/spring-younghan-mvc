package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ModelView {

    @NonNull
    private String viewName;
    private Map<String, Object> model = new HashMap<>();
}
