import java.util.ArrayList;
import java.util.List;

public class File {
	String pathname;
	File parent;
	List<File> childs = new ArrayList<>();
	boolean isDirectory;
	boolean flag;
	String data;

	
	public File() {
		this.pathname = null;
		this.parent = null;
		this.isDirectory = false;
		this.flag = false;
		this.data = null;
	}

	public File(String pathname, String data) {
		this.pathname = pathname;
		this.parent = null;
		this.isDirectory = false;
		this.flag = false;
		this.data = data;
	}
	
	public String getPathname() {
		return pathname;
	}

	public File getParent() {
		return parent;
	}

	public List<File> getChilds() {
		return childs;
	}

	public boolean isDirectory() {
		return isDirectory;
	}

	public boolean getFlag() {
		return flag;
	}

	public String getData() {
		return data;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public void setParent(File parent) {
		this.parent = parent;
	}

	public File addChild(File child) {
		child.setParent(this);
		this.childs.add(child);
		return child;
	}

	public void addChildren(List<File> children) {
		children.forEach(each -> each.setParent(this));
		this.childs.addAll(children);
	}

	public void setChilds(List<File> childs) {
		this.childs = childs;
	}

	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static File mkdir(String pathname) {
		File dir = new File();
		dir.setPathname(pathname);
		dir.setDirectory(true);
		return dir;
	}
	
	public static void ls(File node) {
		System.out.println(node);
		node.getChilds().forEach(each ->  ls(each));
	}
	
	@Override
	public String toString() {
		if (this.isDirectory()) {
			return this.getPathname();
		}
		return this.getPathname()+" : "+this.getData();
	}
}
