package cn.boommanpro.generator;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@Data(staticConstructor = "of")
@Accessors(chain = true)
public class GeneratorFile {
    @NonNull
    private String fileName;
    private String content = null;
    private boolean executable = false;
}
