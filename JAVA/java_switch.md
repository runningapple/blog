```java
public static void main(String[] paramArrayOfString)
  {
    int i = 1;
    switch (i)
    {
    case 1: 
      System.out.println("1");
      break;
    case 2: 
      System.out.println("2");
      break;
    }
    int j = 97;
    switch (j)
    {
    case 97: 
      System.out.println("a");
      break;
    case 98: 
      System.out.println("b");
      break;
    }
    String str = "hello";
    Object localObject = str;int k = -1;
    switch (((String)localObject).hashCode())
    {
    case 99162322: 
      if (((String)localObject).equals("hello")) {
        k = 0;
      }
      break;
    case 113318802: 
      if (((String)localObject).equals("world")) {
        k = 1;
      }
      break;
    }
    switch (k)
    {
    case 0: 
      System.out.println("hello");
      break;
    case 1: 
      System.out.println("world?");
      break;
    }
    localObject = Color.BLACK;
    switch (GenericMethodTest.1.$SwitchMap$Color[localObject.ordinal()])
    {
    case 1: 
      System.out.println("blue");
      break;
    case 2: 
      System.out.println("black");
      break;
    }
  }
```

```java
    public static void main(String[] args) {

        int i = 1;
        switch (i) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                break;
        }

        char c = 'a';
        switch (c) {
            case 'a':
                System.out.println("a");
                break;
            case 'b':
                System.out.println("b");
                break;
            default:
                break;
        }

        String str = "hello";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world?");
                break;
            default:
                break;
        }

        Color color = Color.BLACK;
        switch (color) {
            case BLUE:
                System.out.println("blue");
                break;
            case BLACK:
                System.out.println("black");
                break;
            default:
                break;
        }
    }
```

```java
enum Color {
    BLACK("黑色", 1), BLUE("蓝色", 2), RED("红色", 3);

    private String name;
    private int index;

    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
```