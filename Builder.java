import java.util.*;

class Build{
	int length;
	int width;
	public Build(int length, int width){
		this.length = length;
		this.width = width;
	}

	public String builder(int blength, int bwidth, int count) throws ShortageException, TendorException{
		if (this.length%blength==0 && (blength*bwidth<=count)){
			System.out.println("Builder!!");
		}
		else if(this.length%blength==0 && this.width%bwidth==0 && blength*bwidth > count){
			throw new ShortageException("Need more bricks");
		}
		else if(this.length%blength==1 && this.width%bwidth==1 && (blength*bwidth <= count)){
			throw new TendorException("Building dimension mismatched");
		}
		else if(this.length%blength==1 && this.width%bwidth==1 && (blength*bwidth >= count)){
			throw new ShortageException("Need more bricks with dimension mismatched");
		}

		return null;
	}
}

class ShortageException extends Exception{
	public ShortageException(String errorMessage){
		super(errorMessage);
	}
}

class TendorException extends Exception{
	public TendorException(String errorMessage){
		super(errorMessage);
	}
}

class Builder{
	public static void main(String[] args) {
		try{
			Build build = new Build(100, 100);
			build.builder(10, 10, 100);
			build.builder(10, 10, 50);
		}
		catch (ShortageException ex){
			System.out.println(ex);
		}
		catch (TendorException ex){
			System.out.println(ex);
		}
	}
}