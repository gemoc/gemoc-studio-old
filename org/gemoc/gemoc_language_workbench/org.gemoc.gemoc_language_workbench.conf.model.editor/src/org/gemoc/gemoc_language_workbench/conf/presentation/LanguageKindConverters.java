package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.gemoc.gemoc_language_workbench.conf.LanguageKind;

public class LanguageKindConverters {

	private static abstract class BoolToLanguageKindConverter implements
			org.eclipse.core.databinding.conversion.IConverter {

		public abstract LanguageKind getLanguageKind();

		@Override
		public Object getFromType() {
			return Boolean.class;
		}

		@Override
		public Object getToType() {
			return LanguageKind.class;
		}

		@Override
		public Object convert(Object fromObject) {
			Boolean fromObject_cast = (Boolean) fromObject;
			if (fromObject_cast)
				return getLanguageKind();
			else
				return null;
		}
	}

	public static class BoolToDeterministicConverter extends BoolToLanguageKindConverter {
		@Override
		public LanguageKind getLanguageKind() {
			return LanguageKind.DETERMINISTIC;
		}
	}

	public static class BoolToNonDeterministicConverter extends BoolToLanguageKindConverter {
		@Override
		public LanguageKind getLanguageKind() {
			return LanguageKind.NON_DETERMINISTIC;
		}
	}

	private static abstract class LanguageKindConverterToBool implements
			org.eclipse.core.databinding.conversion.IConverter {

		public abstract LanguageKind getLanguageKind();

		@Override
		public Object getFromType() {
			return LanguageKind.class;
		}

		@Override
		public Object getToType() {
			return Boolean.class;
		}

		@Override
		public Object convert(Object fromObject) {
			LanguageKind fromObject_cast = (LanguageKind) fromObject;
			if (fromObject_cast.equals(getLanguageKind()))
				return true;
			else
				return false;
		}
	}

	public static class DeterministicToBoolConverter extends LanguageKindConverterToBool {
		@Override
		public LanguageKind getLanguageKind() {
			return LanguageKind.DETERMINISTIC;
		}
	}

	public static class NonDeterministicToBoolConverter extends LanguageKindConverterToBool {
		@Override
		public LanguageKind getLanguageKind() {
			return LanguageKind.NON_DETERMINISTIC;
		}
	}

}
