## jsTree
- https://codepen.io/william001/pen/JjoeReN

## Toast ui tree
- https://nhn.github.io/tui.tree/latest/

jstree -> create, edit, move 등등 변화가 일어나는 이벤트가 일어난 이후 <br/>
jstree node array 정보에 push를 해주면 좋고 ( ex) depth 등등 )  <br/>
jstree 에서 제공하는 node array에 push가 안된다면 push 한 new node 값을 전역변수에 따로 update해서 관리 <br/>
(isRoot, isHaveChildren과 같이 필요한 bool 타입을 지정해두면 뒤에서 더 편함)

뒷단에서 DB 저장이 복잡하겠지만 저장 버튼이 있으면 last에 한번만 저장하게 유도를 할 수는 있음

- github에서는 code search를 제공 다양한 예제를 통해 생각을 넓힐수있음
https://github.com/search?q=jstree++language%3AJava&type=code&p=1
