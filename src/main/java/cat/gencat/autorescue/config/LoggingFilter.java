/**

Project: AUTORESCUE
Copyright (c) nttdata 2024 

*/
package cat.gencat.autorescue.config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingFilter implements Filter {
	protected static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		var request = (HttpServletRequest) servletRequest;
		var response = (HttpServletResponse) servletResponse;
		addLog(request);
		chain.doFilter(request, response);

	}

	private static void addLog(HttpServletRequest request) throws IOException {
		String requestBody = "";
		if (request instanceof RequestWrapper requestWrapper) {
			requestBody = requestWrapper.getBody();
		}
		Object pathVariable = request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		printLog(request, requestBody, pathVariable);
	}

	private static void printLog(HttpServletRequest request, String requestBody, Object pathVariable)
			throws JsonProcessingException {
		LOGGER.info("===========================request begin================================================");
		LOGGER.info("URI         : {}", request.getRequestURI());
		LOGGER.info("Method      : {}", request.getMethod());
		LOGGER.info("Headers     : {}", request.getHeaderNames());
		request.getHeaderNames().asIterator().forEachRemaining(
				headerName -> LOGGER.info("              {}", headerName + ": " + request.getHeader(headerName)));
		if (pathVariable != null) {
			LOGGER.info("Path Variable: {}", pathVariable);
		}
		if (requestBody != null && !requestBody.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
			Object json = objectMapper.readValue(requestBody, Object.class);
			String formattedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
			LOGGER.info("Request body:  {}", formattedJson);
		}
		LOGGER.info("==========================request end===================================================");
	}

	private static class RequestWrapper extends HttpServletRequestWrapper {
		private final String body;

		public RequestWrapper(HttpServletRequest request) throws IOException {
			super(request);
			ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			while ((length = request.getInputStream().read(buffer)) != -1) {
				resultStream.write(buffer, 0, length);
			}
			this.body = resultStream.toString(StandardCharsets.UTF_8);
		}

		@Override
		public ServletInputStream getInputStream() {
			final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
			return new ServletInputStream() {
				@Override
				public int read() {
					return byteArrayInputStream.read();
				}

				@Override
				public boolean isFinished() {
					return byteArrayInputStream.available() == 0;
				}

				@Override
				public boolean isReady() {
					return true;
				}

				@Override
				public void setReadListener(ReadListener readListener) {
					// empty method
				}
			};
		}

		public String getBody() {
			return body;
		}
	}

}
