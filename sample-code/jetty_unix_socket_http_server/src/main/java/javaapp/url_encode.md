## url encode/decode
```
使用场景：
py/go和java本机进程通信，采用unix socket方式，
使用py/go写的unix socket http client发送http请求给java jetty的unix socket http server,
url中的passwd会有#&等特殊字符，需要url encode/decode一下。
```

```python
from urllib.parse import quote 
# url encode
passwd = "cd#@!$%^&*()_+zz"
print(quote(passwd))
```

```go
package main

import (
	"fmt"
	"net/url"
)

func main() {
    // url encode
	var s string = url.QueryEscape("cd#@!$%^&*()_+zz")
	fmt.Println(s)
}
```

```java
import java.net.URLDecoder;

public class main {
    public static void main( String[] args ) throws Exception{
            String passwd = "cd%23%40!%24%25%5e%26*()_%2bzz";
            // url decode, (jetty会自动解码的,所以不需要再url decode了)
            passwd = URLDecoder.decode(passwd, "utf-8");
            System.out.println(passwd);
        }
    }
```
